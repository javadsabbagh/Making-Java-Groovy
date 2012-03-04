import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class GameServiceIntegrationTests {
	@Test
	void testGameService() {
		String response = 
			"http://localhost:8080/groovybaseball/GamesService.groovy?month=10&day=28&year=2007".toURL().text
		def games = new XmlSlurper().parseText(response)
		assert 1 == games.game.size()
		assert games.game[0].@outcome.toString().contains('Boston')
		assert games.game[0].@outcome.toString().contains('Colorado')
	}
}