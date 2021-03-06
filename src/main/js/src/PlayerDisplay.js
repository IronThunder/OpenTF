import React, {Component} from 'react'
import {connect} from 'react-redux'
import ProductionDisplay from './ProductionDisplay'
import TableauDisplay from './TableauDisplay'
import HandDisplay from './HandDisplay'

class PlayerDisplay extends Component {
  score = 27

  render() {
    if (!this.props.player) return <div>Loading</div>

    const resources = this.props.player.resources
    const tableau = this.props.player.tableau
    const hand = this.props.player.hand

    return (
        <div>
          <ProductionDisplay resources={resources} score={this.score}/>
          <TableauDisplay tableau={tableau}/>
          <HandDisplay cards={hand} resources={resources}/>
        </div>)
  }
}

const mapStateToProps = state => {
  return {
    player: state.gamestate.players ? state.gamestate.players[state.gamestate.active] : null
  }
}

const PlayerDisplayConnected = connect(mapStateToProps)(PlayerDisplay)

export default PlayerDisplayConnected