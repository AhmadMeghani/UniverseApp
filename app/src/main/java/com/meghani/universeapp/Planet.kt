package com.meghani.universeapp

import androidx.annotation.DrawableRes

data class Planet(
    @DrawableRes val image: Int,
    val planetName: String,
    val planetDescription: String,
    val index: Int = 1,
    val longDescription: String = ""
)



fun loadPlanetList(): List<Planet> {
    return listOf(
        Planet(
            planetName = "Mercury",
            planetDescription = "Tiny inferno, closest to the Sun with wild temperature swings.",
            image = R.drawable.copy_of_black_and_grey_minimalist_simple_modern_square_hipster_stone_logo__1000_x_500_px___14_,
            longDescription = "Tiny inferno, closest to the Sun with wild temperature swings. Scorched by day, freezing by night, it has no atmosphere."
        ),
        Planet(
            planetName = "Venus",
            planetDescription = "Burning beauty, hottest planet with a thick, toxic atmosphere.",
            image = R.drawable.copy_of_black_and_grey_minimalist_simple_modern_square_hipster_stone_logo__1000_x_500_px___18_,
            longDescription = "Burning beauty, hottest planet with a thick, toxic atmosphere. A runaway greenhouse effect traps heat, making it hotter than Mercury."
        ),
        Planet(
            planetName = "Earth",
            planetDescription = "Our oasis, the only known planet to support life with 75% of water.",
            image = R.drawable.ic_earth__1___1_,
            longDescription = "Our oasis, the only known planet to support life. A blue marble with liquid water, diverse life forms, and a protective atmosphere."
        ),
        Planet(
            planetName = "Mars",
            planetDescription = "Rusty neighbor, cold and dry with a thin atmosphere and ancient water.",
            image = R.drawable.copy_of_black_and_grey_minimalist_simple_modern_square_hipster_stone_logo__1000_x_500_px___13_,
            longDescription = "Rusty neighbor, cold and dry with a thin atmosphere and hints of ancient water. Reddish dust covers the surface, with polar ice caps and potential for past life"
        ),
        Planet(
            planetName = "Jupiter",
            planetDescription = "Giant king, swirling atmosphere with a giant storm bigger than Earth..",
            image = R.drawable.copy_of_black_and_grey_minimalist_simple_modern_square_hipster_stone_logo__1000_x_500_px___12_,
            longDescription = "Giant king, swirling atmosphere with a giant storm bigger than Earth (Great Red Spot). Made mostly of gas, it has a strong gravity and numerous moons."
        ),
        Planet(
            planetName = "Saturn",
            planetDescription = "Ringed wonder, famous for its icy rings and beautiful form.",
            image = R.drawable.copy_of_black_and_grey_minimalist_simple_modern_square_hipster_stone_logo__1000_x_500_px___17_,
            longDescription = "Ringed wonder, famous for its stunning icy rings and beautiful form. A gas giant with a tilted axis and a complex system of moons."
        ),
        Planet(
            planetName = "Neptune",
            planetDescription = "Distant wanderer, farthest planet with supersonic winds and a dark blue hue.",
            image = R.drawable.copy_of_black_and_grey_minimalist_simple_modern_square_hipster_stone_logo__1000_x_500_px___15_,
            longDescription = "Distant wanderer, farthest planet with supersonic winds and a dark blue hue. An ice giant with the strongest winds in the solar system and a dark blue methane atmosphere."
        ),
        Planet(
            planetName = "Pluto",
            planetDescription = "Icy dwarf, once a planet, cold and small with moons.",
            image = R.drawable.copy_of_black_and_grey_minimalist_simple_modern_square_hipster_stone_logo__1000_x_500_px___16_,
            longDescription = "Icy dwarf, once a planet, cold and small with moons. A small, icy world beyond Neptune, rich in frozen nitrogen and methane, with its own moons"
        )
    )

}

fun getDefaultPlanet(): Planet {
    return Planet(
        planetName = "Jupiter",
        planetDescription = "Giant King, swirling atmosphere with a giant storm bigger than earth.",
        image = R.drawable.copy_of_black_and_grey_minimalist_simple_modern_square_hipster_stone_logo__1000_x_500_px___17_
    )
}