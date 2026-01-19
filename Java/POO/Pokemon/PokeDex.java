import java.util.ArrayList;
public class PokeDex
{
Pokemon[] pokemones = new Pokemon[151];

public PokeDex(){
pokemones[1] = new Pokemon(1,"Bulbasaur","Grass",49,49,"Golpehoja",50,"Tormenta Mistica","DebuffD",87);
pokemones[2] = new Pokemon(2,"Ivysaur","Grass",62,63,"Golpehoja",49,"Explosion Eterea","DebuffD",98);
pokemones[3] = new Pokemon(3,"Venusaur","Grass",82,83,"Latigo Verde",44,"Rugido Solar","buffD",73);
pokemones[4] = new Pokemon(4,"Charmander","Fire",52,43,"Ascuas",51,"Explosion Eterea","DebuffD",95);
pokemones[5] = new Pokemon(5,"Charmeleon","Fire",64,58,"Ascuas",54,"Rugido Solar","buffD",78);
pokemones[6] = new Pokemon(6,"Charizard","Fire",84,78,"Fuego Rapido",48,"Tormenta Mistica","debuffA",76);
pokemones[7] = new Pokemon(7,"Squirtle","Water",48,65,"Chorro Aqua",48,"Grito de Guerra","buffD",86);
pokemones[8] = new Pokemon(8,"Wartortle","Water",63,80,"Salpicadura",45,"Eco Final","debuffA",73);
pokemones[9] = new Pokemon(9,"Blastoise","Water",83,100,"Burbuja",49,"Grito de Guerra","DebuffD",86);
pokemones[10] = new Pokemon(10,"Caterpie","Bug",30,35,"Golpe Insecto",42,"Aura Salvaje","debuffA",73);
pokemones[11] = new Pokemon(11,"Metapod","Bug",20,55,"Ala Cuchilla",41,"Aura Salvaje","buffD",99);
pokemones[12] = new Pokemon(12,"Butterfree","Bug",45,50,"Golpe Insecto",51,"Tormenta Mistica","buffA",85);
pokemones[13] = new Pokemon(13,"Weedle","Bug",35,30,"Picadura",47,"Aura Salvaje","debuffA",70);
pokemones[14] = new Pokemon(14,"Kakuna","Bug",25,50,"Picadura",60,"Aura Salvaje","buffA",92);
pokemones[15] = new Pokemon(15,"Beedrill","Bug",90,40,"Golpe Insecto",48,"Corte Dimensional","debuffA",94);
pokemones[16] = new Pokemon(16,"Pidgey","Normal",45,40,"Golpe Normal",50,"Grito de Guerra","buffD",94);
pokemones[17] = new Pokemon(17,"Pidgeotto","Normal",60,55,"Golpe Normal",60,"Explosion Eterea","debuffA",72);
pokemones[18] = new Pokemon(18,"Pidgeot","Normal",80,75,"Golpe Normal",48,"Grito de Guerra","debuffA",85);
pokemones[19] = new Pokemon(19,"Rattata","Normal",56,35,"Golpe Normal",50,"Grito de Guerra","DebuffD",84);
pokemones[20] = new Pokemon(20,"Raticate","Normal",81,60,"Ataque Rapido",48,"Rugido Solar","DebuffD",85);
pokemones[21] = new Pokemon(21,"Spearow","Normal",60,30,"Ataque Rapido",44,"Eco Final","debuffA",85);
pokemones[22] = new Pokemon(22,"Fearow","Normal",90,65,"Golpe Normal",57,"Eco Final","buffA",92);
pokemones[23] = new Pokemon(23,"Ekans","Poison",60,44,"Mordisco Acido",44,"Rugido Solar","DebuffD",72);
pokemones[24] = new Pokemon(24,"Arbok","Poison",85,69,"Veneno Rapido",48,"Aura Salvaje","DebuffD",73);
pokemones[25] = new Pokemon(25,"Pikachu","Electric",55,40,"Descarga",60,"Explosion Eterea","DebuffD",98);
pokemones[26] = new Pokemon(26,"Raichu","Electric",90,55,"Impactrueno",47,"Grito de Guerra","buffD",72);
pokemones[27] = new Pokemon(27,"Sandshrew","Ground",75,85,"Sacudida",50,"Grito de Guerra","buffD",97);
pokemones[28] = new Pokemon(28,"Sandslash","Ground",100,110,"Terremotito",52,"Grito de Guerra","DebuffD",96);
pokemones[29] = new Pokemon(29,"Nidoran","Poison",47,52,"Picotazo Venenoso",56,"Corte Dimensional","debuffA",81);
pokemones[30] = new Pokemon(30,"Nidorina","Poison",62,67,"Picotazo Venenoso",45,"Corte Dimensional","buffD",75);
pokemones[31] = new Pokemon(31,"Nidoqueen","Poison",92,87,"Picotazo Venenoso",51,"Eco Final","debuffA",71);
pokemones[32] = new Pokemon(32,"Nidoran","Poison",57,40,"Veneno Rapido",50,"Rugido Solar","debuffA",81);
pokemones[33] = new Pokemon(33,"Nidorino","Poison",72,57,"Picotazo Venenoso",59,"Explosion Eterea","buffA",97);
pokemones[34] = new Pokemon(34,"Nidoking","Poison",102,77,"Picotazo Venenoso",51,"Grito de Guerra","DebuffD",78);
pokemones[35] = new Pokemon(35,"Clefairy","Fairy",45,48,"Brillo Magico",55,"Explosion Eterea","buffA",96);
pokemones[36] = new Pokemon(36,"Clefable","Fairy",70,73,"Toque Dulce",54,"Corte Dimensional","buffD",91);
pokemones[37] = new Pokemon(37,"Vulpix","Fire",41,40,"Llamarada",51,"Aura Salvaje","DebuffD",82);
pokemones[38] = new Pokemon(38,"Ninetales","Fire",76,75,"Fuego Rapido",51,"Tormenta Mistica","debuffA",82);
pokemones[39] = new Pokemon(39,"Jigglypuff","Normal",45,20,"Ataque Rapido",56,"Corte Dimensional","buffA",73);
pokemones[40] = new Pokemon(40,"Wigglytuff","Normal",70,45,"Ataque Rapido",46,"Grito de Guerra","buffA",89);
pokemones[41] = new Pokemon(41,"Zubat","Poison",45,35,"Mordisco Acido",46,"Explosion Eterea","buffD",98);
pokemones[42] = new Pokemon(42,"Golbat","Poison",80,70,"Mordisco Acido",51,"Rugido Solar","buffD",73);
pokemones[43] = new Pokemon(43,"Oddish","Grass",50,55,"Hoja Rapida",46,"Aura Salvaje","buffA",98);
pokemones[44] = new Pokemon(44,"Gloom","Grass",65,70,"Hoja Rapida",42,"Explosion Eterea","DebuffD",90);
pokemones[45] = new Pokemon(45,"Vileplume","Grass",80,85,"Hoja Rapida",42,"Aura Salvaje","buffD",85);
pokemones[46] = new Pokemon(46,"Paras","Bug",70,55,"Golpe Insecto",55,"Explosion Eterea","debuffA",94);
pokemones[47] = new Pokemon(47,"Parasect","Bug",95,80,"Ala Cuchilla",47,"Corte Dimensional","debuffA",87);
pokemones[48] = new Pokemon(48,"Venonat","Bug",55,50,"Golpe Insecto",40,"Aura Salvaje","buffA",83);
pokemones[49] = new Pokemon(49,"Venomoth","Bug",65,60,"Golpe Insecto",48,"Corte Dimensional","DebuffD",90);
pokemones[50] = new Pokemon(50,"Diglett","Ground",55,25,"Terremotito",40,"Aura Salvaje","debuffA",97);
pokemones[51] = new Pokemon(51,"Dugtrio","Ground",80,50,"Golpe Tierra",58,"Aura Salvaje","DebuffD",75);
pokemones[52] = new Pokemon(52,"Meowth","Normal",45,35,"Golpe Normal",55,"Aura Salvaje","buffA",99);
pokemones[53] = new Pokemon(53,"Persian","Normal",70,60,"Golpe Normal",52,"Corte Dimensional","DebuffD",74);
pokemones[54] = new Pokemon(54,"Psyduck","Water",52,48,"Salpicadura",54,"Tormenta Mistica","DebuffD",90);
pokemones[55] = new Pokemon(55,"Golduck","Water",82,78,"Burbuja",52,"Explosion Eterea","debuffA",99);
pokemones[56] = new Pokemon(56,"Mankey","Fighting",80,35,"Golpe Directo",56,"Aura Salvaje","debuffA",90);
pokemones[57] = new Pokemon(57,"Primeape","Fighting",105,60,"Golpe Karate",58,"Explosion Eterea","DebuffD",86);
pokemones[58] = new Pokemon(58,"Growlithe","Fire",70,45,"Fuego Rapido",57,"Corte Dimensional","buffD",78);
pokemones[59] = new Pokemon(59,"Arcanine","Fire",110,80,"Ascuas",54,"Explosion Eterea","buffA",83);
pokemones[60] = new Pokemon(60,"Poliwag","Water",50,40,"Burbuja",46,"Rugido Solar","buffA",91);
pokemones[61] = new Pokemon(61,"Poliwhirl","Water",65,65,"Salpicadura",50,"Tormenta Mistica","buffD",81);
pokemones[62] = new Pokemon(62,"Poliwrath","Water",95,95,"Salpicadura",52,"Eco Final","debuffA",93);
pokemones[63] = new Pokemon(63,"Abra","Psychic",20,15,"Confusion",55,"Aura Salvaje","DebuffD",95);
pokemones[64] = new Pokemon(64,"Kadabra","Psychic",35,30,"Confusion",56,"Aura Salvaje","debuffA",96);
pokemones[65] = new Pokemon(65,"Alakazam","Psychic",50,45,"Onda Psiquica",50,"Explosion Eterea","debuffA",80);
pokemones[66] = new Pokemon(66,"Machop","Fighting",80,50,"Golpe Directo",49,"Aura Salvaje","debuffA",83);
pokemones[67] = new Pokemon(67,"Machoke","Fighting",100,70,"Golpe Karate",46,"Rugido Solar","buffA",84);
pokemones[68] = new Pokemon(68,"Machamp","Fighting",130,80,"Puno Rapido",41,"Eco Final","buffA",93);
pokemones[69] = new Pokemon(69,"Bellsprout","Grass",75,35,"Latigo Verde",43,"Rugido Solar","buffD",87);
pokemones[70] = new Pokemon(70,"Weepinbell","Grass",90,50,"Latigo Verde",46,"Tormenta Mistica","debuffA",78);
pokemones[71] = new Pokemon(71,"Victreebel","Grass",105,65,"Hoja Rapida",60,"Explosion Eterea","buffA",98);
pokemones[72] = new Pokemon(72,"Tentacool","Water",40,35,"Chorro Aqua",44,"Eco Final","debuffA",78);
pokemones[73] = new Pokemon(73,"Tentacruel","Water",70,65,"Salpicadura",58,"Corte Dimensional","DebuffD",96);
pokemones[74] = new Pokemon(74,"Geodude","Rock",80,100,"Golpe Duro",56,"Corte Dimensional","debuffA",82);
pokemones[75] = new Pokemon(75,"Graveler","Rock",95,115,"Roca Filosa",55,"Corte Dimensional","buffA",77);
pokemones[76] = new Pokemon(76,"Golem","Rock",120,130,"Roca Filosa",46,"Tormenta Mistica","DebuffD",86);
pokemones[77] = new Pokemon(77,"Ponyta","Fire",85,55,"Fuego Rapido",57,"Aura Salvaje","DebuffD",93);
pokemones[78] = new Pokemon(78,"Rapidash","Fire",100,70,"Llamarada",56,"Tormenta Mistica","DebuffD",99);
pokemones[79] = new Pokemon(79,"Slowpoke","Water",65,65,"Salpicadura",47,"Aura Salvaje","DebuffD",75);
pokemones[80] = new Pokemon(80,"Slowbro","Water",75,110,"Burbuja",57,"Rugido Solar","buffD",96);
pokemones[81] = new Pokemon(81,"Magnemite","Electric",35,70,"Chispa",58,"Corte Dimensional","DebuffD",91);
pokemones[82] = new Pokemon(82,"Magneton","Electric",60,95,"Impactrueno",41,"Grito de Guerra","DebuffD",77);
pokemones[83] = new Pokemon(83,"Farfetch'd","Normal",65,55,"Golpe Normal",44,"Corte Dimensional","debuffA",70);
pokemones[84] = new Pokemon(84,"Doduo","Normal",85,45,"Ataque Rapido",46,"Aura Salvaje","buffD",98);
pokemones[85] = new Pokemon(85,"Dodrio","Normal",110,70,"Placaje",47,"Corte Dimensional","buffA",82);
pokemones[86] = new Pokemon(86,"Seel","Water",45,55,"Salpicadura",51,"Eco Final","buffA",93);
pokemones[87] = new Pokemon(87,"Dewgong","Water",70,80,"Salpicadura",52,"Aura Salvaje","buffD",93);
pokemones[88] = new Pokemon(88,"Grimer","Poison",80,50,"Mordisco Acido",53,"Grito de Guerra","buffA",91);
pokemones[89] = new Pokemon(89,"Muk","Poison",105,75,"Veneno Rapido",52,"Eco Final","buffD",93);
pokemones[90] = new Pokemon(90,"Shellder","Water",65,100,"Burbuja",60,"Explosion Eterea","debuffA",77);
pokemones[91] = new Pokemon(91,"Cloyster","Water",95,180,"Salpicadura",50,"Corte Dimensional","DebuffD",70);
pokemones[92] = new Pokemon(92,"Gastly","Ghost",35,30,"Toque Fantasma",50,"Eco Final","buffA",74);
pokemones[93] = new Pokemon(93,"Haunter","Ghost",50,45,"Sombra Rapida",59,"Explosion Eterea","DebuffD",71);
pokemones[94] = new Pokemon(94,"Gengar","Ghost",65,60,"Sombra Rapida",46,"Grito de Guerra","debuffA",79);
pokemones[95] = new Pokemon(95,"Onix","Rock",45,160,"Golpe Duro",43,"Eco Final","buffA",77);
pokemones[96] = new Pokemon(96,"Drowzee","Psychic",48,45,"Onda Psiquica",52,"Aura Salvaje","buffD",85);
pokemones[97] = new Pokemon(97,"Hypno","Psychic",73,70,"Onda Psiquica",48,"Rugido Solar","buffD",97);
pokemones[98] = new Pokemon(98,"Krabby","Water",105,90,"Salpicadura",59,"Tormenta Mistica","debuffA",80);
pokemones[99] = new Pokemon(99,"Kingler","Water",130,115,"Burbuja",53,"Aura Salvaje","DebuffD",72);
pokemones[100] = new Pokemon(100,"Voltorb","Electric",30,50,"Chispa",49,"Tormenta Mistica","debuffA",73);
pokemones[101] = new Pokemon(101,"Electrode","Electric",50,70,"Chispa",44,"Corte Dimensional","DebuffD",82);
pokemones[102] = new Pokemon(102,"Exeggcute","Grass",40,80,"Hoja Rapida",45,"Tormenta Mistica","buffD",90);
pokemones[103]= new Pokemon(103,"Exeggutor","Grass",95,85,"Golpehoja",55,"Corte Dimensional","buffA",87);
pokemones[104] = new Pokemon(104,"Cubone","Ground",50,95,"Golpe Tierra",59,"Rugido Solar","buffD",92);
pokemones[105] = new Pokemon(105,"Marowak","Ground",80,110,"Terremotito",47,"Rugido Solar","DebuffD",99);
pokemones[106] = new Pokemon(106,"Hitmonlee","Fighting",120,53,"Golpe Directo",59,"Eco Final","debuffA",100);
pokemones[107] = new Pokemon(107,"Hitmonchan","Fighting",105,79,"Golpe Directo",40,"Aura Salvaje","buffA",78);
pokemones[108] = new Pokemon(108,"Lickitung","Normal",55,75,"Golpe Normal",53,"Explosion Eterea","DebuffD",96);
pokemones[109] = new Pokemon(109,"Koffing","Poison",65,95,"Picotazo Venenoso",55,"Explosion Eterea","DebuffD",100);
pokemones[110] = new Pokemon(110,"Weezing","Poison",90,120,"Veneno Rapido",52,"Corte Dimensional","DebuffD",93);
pokemones[111] = new Pokemon(111,"Rhyhorn","Ground",85,95,"Terremotito",53,"Rugido Solar","buffD",77);
pokemones[112] = new Pokemon(112,"Rhydon","Ground",130,120,"Sacudida",60,"Aura Salvaje","debuffA",82);
pokemones[113] = new Pokemon(113,"Chansey","Normal",5,5,"Ataque Rapido",41,"Rugido Solar","buffA",76);
pokemones[114] = new Pokemon(114,"Tangela","Grass",55,115,"Latigo Verde",56,"Explosion Eterea","DebuffD",91);
pokemones[115] = new Pokemon(115,"Kangaskhan","Normal",95,80,"Placaje",43,"Explosion Eterea","buffA",80);
pokemones[116] = new Pokemon(116,"Horsea","Water",40,70,"Chorro Aqua",42,"Aura Salvaje","buffA",98);
pokemones[117] = new Pokemon(117,"Seadra","Water",65,95,"Chorro Aqua",58,"Tormenta Mistica","debuffA",78);
pokemones[118] = new Pokemon(118,"Goldeen","Water",67,60,"Salpicadura",60,"Tormenta Mistica","DebuffD",83);
pokemones[119] = new Pokemon(119,"Seaking","Water",92,65,"Salpicadura",51,"Eco Final","buffD",79);
pokemones[120] = new Pokemon(120,"Staryu","Water",45,55,"Chorro Aqua",41,"Aura Salvaje","DebuffD",94);
pokemones[121] = new Pokemon(121,"Starmie","Water",75,85,"Burbuja",45,"Grito de Guerra","DebuffD",78);
pokemones[122] = new Pokemon(122,"Mr. Mime","Psychic",45,65,"Confusion",50,"Aura Salvaje","buffA",90);
pokemones[123] = new Pokemon(123,"Scyther","Bug",110,80,"Picadura",46,"Explosion Eterea","debuffA",70);
pokemones[124] = new Pokemon(124,"Jynx","Ice",50,35,"Toque Helado",49,"Grito de Guerra","DebuffD",87);
pokemones[125] = new Pokemon(125,"Electabuzz","Electric",83,57,"Impactrueno",45,"Eco Final","buffA",99);
pokemones[126] = new Pokemon(126,"Magmar","Fire",95,57,"Llamarada",50,"Corte Dimensional","DebuffD",70);
pokemones[127] = new Pokemon(127,"Pinsir","Bug",125,100,"Picadura",55,"Aura Salvaje","DebuffD",100);
pokemones[128] = new Pokemon(128,"Tauros","Normal",100,95,"Placaje",43,"Grito de Guerra","buffA",71);
pokemones[129] = new Pokemon(129,"Magikarp","Water",10,55,"Burbuja",59,"Rugido Solar","buffA",86);
pokemones[130] = new Pokemon(130,"Gyarados","Water",125,79,"Burbuja",49,"Tormenta Mistica","buffA",99);
pokemones[131] = new Pokemon(131,"Lapras","Water",85,80,"Burbuja",42,"Grito de Guerra","DebuffD",77);
pokemones[132] = new Pokemon(132,"Ditto","Normal",48,48,"Golpe Normal",49,"Eco Final","buffA",83);
pokemones[133] = new Pokemon(133,"Eevee","Normal",55,50,"Placaje",49,"Explosion Eterea","buffD",89);
pokemones[134] = new Pokemon(134,"Vaporeon","Water",65,60,"Salpicadura",52,"Corte Dimensional","debuffA",74);
pokemones[135] = new Pokemon(135,"Jolteon","Electric",65,60,"Impactrueno",53,"Corte Dimensional","DebuffD",96);
pokemones[136] = new Pokemon(136,"Flareon","Fire",130,60,"Fuego Rapido",51,"Rugido Solar","buffA",71);
pokemones[137] = new Pokemon(137,"Porygon","Normal",60,70,"Ataque Rapido",58,"Eco Final","buffA",82);
pokemones[138] = new Pokemon(138,"Omanyte","Rock",40,100,"Roca Filosa",49,"Grito de Guerra","buffA",72);
pokemones[139] = new Pokemon(139,"Omastar","Rock",60,125,"Lanzarrocas",44,"Eco Final","buffD",73);
pokemones[140] = new Pokemon(140,"Kabuto","Rock",80,90,"Lanzarrocas",50,"Corte Dimensional","buffD",95);
pokemones[141] = new Pokemon(141,"Kabutops","Rock",115,105,"Roca Filosa",55,"Tormenta Mistica","buffA",85);
pokemones[142] = new Pokemon(142,"Aerodactyl","Rock",105,65,"Golpe Duro",51,"Explosion Eterea","debuffA",79);
pokemones[143] = new Pokemon(143,"Snorlax","Normal",110,65,"Placaje",57,"Grito de Guerra","debuffA",77);
pokemones[144] = new Pokemon(144,"Articuno","Ice",85,100,"Viento Hielo",58,"Eco Final","buffA",79);
pokemones[145] = new Pokemon(145,"Zapdos","Electric",90,85,"Impactrueno",45,"Aura Salvaje","debuffA",76);
pokemones[146] = new Pokemon(146,"Moltres","Fire",100,90,"Llamarada",58,"Explosion Eterea","buffA",82);
pokemones[147] = new Pokemon(147,"Dratini","Dragon",64,45,"Garra de Dragon",49,"Corte Dimensional","buffD",78);
pokemones[148] = new Pokemon(148,"Dragonair","Dragon",84,65,"Aliento Feroz",40,"Explosion Eterea","DebuffD",78);
pokemones[149] = new Pokemon(149,"Dragonite","Dragon",134,95,"Cola Dragon",47,"Grito de Guerra","DebuffD",96);
pokemones[150] = new Pokemon(150,"Mewtwo","Psychic",110,90,"Poder Mental",49,"Corte Dimensional","buffA",79);
}

// DISCLAIMER: ESTA PARTE DEL CODIGO SI ME AYUDO LA IA PQ LA VERDAD NO SABIA COMO HACER ESTO CON UN MAPA TAN GRANDE
//public Pokemon getPokemon(int number) {
//       try {
//            Field field = this.getClass().getDeclaredField("p" + number);
//            return (Pokemon) field.get(this);
 //       } catch (NoSuchFieldException e) {
  //          throw new IllegalArgumentException("No Pokemon with number " + number);
   //     } catch (IllegalAccessException e) {
     //       throw new RuntimeException("Error accessing Pokemon field", e);
       // }
//}

public Pokemon getPokemon(int numero) {

    return this.pokemones[numero];
}
}