import { useEffect, useState } from 'react'
import MatchDetailCard from '../components/MatchDetailCard'
import MatchSmallCard from '../components/MatchSmallCard'

export const TeamPage = () => {
  const [team, setTeam] = useState({ matches: [] })
  let mostRecentMatch = []
  let recentMatches = []

  useEffect(() => {
    const fetchMatches = async () => {
      const response = await fetch(
        'http://localhost:8080/team/Delhi%20Capitals'
      )
      const data = await response.json()
      setTeam(data)
    }

    fetchMatches()
  }, [])

  if (team.matches.length) {
    mostRecentMatch = team.matches[0]
    recentMatches = team.matches.slice(1)
  }

  console.log('--> team', team)
  console.log('--> mostRecentMatch', mostRecentMatch)
  console.log('--> recentMatches', recentMatches)

  return (
    <div className="TeamPage">
      <h1>{team.teamName}</h1>

      <MatchDetailCard match={mostRecentMatch} />

      {recentMatches.map((match) => (
        <MatchSmallCard key={match.id} match={match} />
      ))}
    </div>
  )
}
