import React from 'react'

const MatchSmallCard = ({ match }) => {
  if (!match) return null

  return (
    <div className="MatchSmallCard">
      <p className="">
        {match.team1} - {match.team2}
      </p>
    </div>
  )
}

export default MatchSmallCard
