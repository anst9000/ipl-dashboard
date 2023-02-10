import React from 'react'

const MatchDetailCard = ({ match }) => {
  if (!match) return null

  console.log('--> match in MatchDetailCard', match)

  return (
    <div className="MatchDetailCard">
      <h2>Latest Matches</h2>
      <h3>Match Details</h3>
      <h4>
        {match.team1} - {match.team2}
      </h4>
    </div>
  )
}

export default MatchDetailCard
