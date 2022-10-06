//perfom get request
async function getData(url) {
  const response = await fetch(url,{ method: 'GET' })
  const data = await response.json()
  return data
}

function getNormalTypePokemonNameInList(){
	let pkmNormalType = [];
	//retrieve 30 first pokemons
	getData('https://pokeapi.co/api/v2/pokemon?limit=30').then(pokemonList => {
		//loop on every pokemon url details
		pokemonList.results.forEach(pkm => {
			//retrieve pokemon detail
			getData(pkm.url).then(pokemon => {
				
				is_normal_type = false;
				//loop on each pokemon types
				pokemon.types.forEach(type => {
					//flag if type = normal
					if(type.type.name == 'normal')
						is_normal_type = true;
				})
				//store in array pokemon name if type = normal
				if(is_normal_type == true)
					pkmNormalType.push(pokemon.forms[0].name)
				
			})
		})
	})
	console.log(pkmNormalType)
	return pkmNormalType;
}