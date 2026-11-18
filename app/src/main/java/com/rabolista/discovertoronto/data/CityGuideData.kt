package com.rabolista.discovertoronto.data

import com.rabolista.discovertoronto.model.Place
import com.rabolista.discovertoronto.model.PlaceSection

// Converted from CityGuideData.swift
object CityGuideData {

    fun sections(city: String): List<PlaceSection> = when (city) {
        "Toronto" -> toronto
        "Mississauga" -> mississauga
        "Brampton" -> brampton
        "Vaughan" -> vaughan
        "Markham" -> markham
        "Richmond Hill" -> richmondHill
        "Oakville" -> oakville
        "Burlington" -> burlington
        "Ajax" -> ajax
        "Oshawa" -> oshawa
        else -> emptyList()
    }

    private val toronto: List<PlaceSection> = listOf(
        PlaceSection(title = "Top Attractions", places = listOf(
            Place(
                name = "CN Tower",
                category = "Landmark",
                details = "Standing 553.3 metres tall, the CN Tower served as the world's tallest freestanding structure from 1976 to 2010 and remains the defining symbol of Toronto's skyline. Visitors can brave the EdgeWalk — a hands-free walk along the roof's edge 356 metres above the ground — or look straight down through the glass floor observation pod. The 360 Restaurant revolves slowly to give diners a complete panoramic view of the city and Lake Ontario below.",
                systemImage = "building.2.crop.circle.fill",
                imageName = "CNTower",
                address = "290 Bremner Blvd, Toronto, ON M5V 3L9",
            ),
            Place(
                name = "Ripley's Aquarium of Canada",
                category = "Attraction",
                details = "Opened in 2013 beside the CN Tower, Ripley's Aquarium of Canada holds over 20,000 sea creatures in 5.7 million litres of water across ten themed galleries. The centrepiece is a 97-metre moving walkway tunnel passing through shark-filled Caribbean waters, with giant sawfish and sand tiger sharks gliding overhead. A rare loggerhead sea turtle, touch tanks, glowing jellyfish, and daily dive shows make it a full-day experience for all ages.",
                systemImage = "fish.fill",
                imageName = "RipleysAquarium",
                address = "288 Bremner Blvd, Toronto, ON M5V 3L9",
            ),
            Place(
                name = "Royal Ontario Museum (ROM)",
                category = "Museum",
                details = "The Royal Ontario Museum is Canada's largest museum of natural history and world cultures, with a permanent collection of nearly six million objects across 40 galleries. Frank Gehry's dramatic Michael Lee-Chin Crystal addition — a faceted glass and aluminium structure — opened in 2007 and transformed the museum's street presence on Bloor Street West. Signature exhibits include a gallery of mounted dinosaur skeletons, ancient Egyptian mummies, and one of the world's finest collections of Chinese art.",
                systemImage = "building.columns.fill",
                imageName = "ROM",
                address = "100 Queens Park, Toronto, ON M5S 2C6",
            ),
            Place(
                name = "Casa Loma",
                category = "Historic Site",
                details = "Casa Loma is a 98-room Gothic Revival castle completed in 1914 for financier Sir Henry Pellatt at a then-staggering cost of \$3.5 million. The estate features secret passages, underground tunnels linking the main house to the stables, and towers offering sweeping views of the Toronto skyline and Lake Ontario. Today it operates as a public museum and event venue, and regularly ranks as one of Canada's most-visited National Historic Sites.",
                systemImage = "crown.fill",
                imageName = "CasaLoma",
                address = "1 Austin Terrace, Toronto, ON M5R 1X8",
            ),
            Place(
                name = "Art Gallery of Ontario (AGO)",
                category = "Museum",
                details = "The Art Gallery of Ontario holds a permanent collection of nearly 100,000 works spanning 2,000 years across 90,000 square metres of gallery space. Architect Frank Gehry — who grew up near the gallery — redesigned the Dundas Street West façade in 2008 with a spectacular wood and glass addition. The collection excels in Canadian and Indigenous art, the Thomson Collection of European Old Masters, and works from Africa and Oceania.",
                systemImage = "paintpalette.fill",
                imageName = "AGO",
                address = "317 Dundas St W, Toronto, ON M5T 1G4",
            ),
            Place(
                name = "Toronto Islands",
                category = "Outdoors",
                details = "The Toronto Islands are a car-free archipelago of 15 small islands reachable by a 10-minute ferry from the Jack Layton Ferry Terminal on Queens Quay. Centre Island offers an amusement park, a petting farm, and the best swimming beaches, while Ward's Island feels like a quiet cottage community with boardwalk homes and gardens. The islands provide the most iconic view of the Toronto skyline, especially at sunset when the CN Tower glows against the lake.",
                systemImage = "sailboat.fill",
                imageName = "TorontoIslands",
                address = "9 Queens Quay W, Toronto, ON M5J 2H3",
            ),
            Place(
                name = "High Park",
                category = "Outdoors",
                details = "High Park is Toronto's largest public green space at 161 hectares, blending a formal civic park with a largely natural section of rare Black Oak savanna. Grenadier Pond is a popular winter skating destination and year-round bird-watching spot, while a small free zoo houses bison, peacocks, and Barbary sheep. Every spring, dozens of Japanese cherry trees burst into bloom, drawing tens of thousands of visitors for the annual Sakura festival.",
                systemImage = "leaf.fill",
                imageName = "HighPark",
                address = "1873 Bloor St W, Toronto, ON M6R 2Z3",
            ),
            Place(
                name = "Yonge-Dundas Square",
                category = "Landmark",
                details = "Yonge-Dundas Square is Toronto's Times Square-style public plaza at the intersection of Yonge Street and Dundas Street East, at the heart of the city's entertainment district. The open plaza hosts over 200 free events per year — outdoor concerts, film festivals, and multicultural celebrations — against a backdrop of giant LED advertising screens. It sits directly outside the Toronto Eaton Centre and is a major hub for the TTC subway and streetcar network.",
                systemImage = "sparkles",
                imageName = "YongeDundasSquare",
                address = "1 Dundas St E, Toronto, ON M5B 2R8",
            ),
            Place(
                name = "Canadian National Exhibition (CNE)",
                category = "Arts & Culture",
                details = "The Canadian National Exhibition is North America's largest annual fair, drawing over 1.5 million visitors during its 18-day run at Exhibition Place on Toronto's western waterfront each August. Established in 1879 as a showcase for Canadian industry and agriculture, the CNE now features a massive midway with over 50 thrill rides, headline concerts, the world-famous SuperDogs show, competitive livestock and agricultural displays, and a legendary food building known for its outrageous deep-fried creations and novelty treats. Admission to the Exhibition grounds is free; midway rides are purchased separately, and the CNE wraps up every year on Labour Day.",
                systemImage = "ticket.fill",
                imageName = "CNE",
                address = "Exhibition Place, Toronto, ON M6K 3C3",
            ),
        )),
        PlaceSection(title = "Neighborhoods & Markets", places = listOf(
            Place(
                name = "Distillery District",
                category = "Neighborhood",
                details = "The Distillery District occupies the former Gooderham and Worts Distillery complex, built between 1832 and 1927, which operated as the British Empire's largest distillery for decades. Designated a National Historic Site of Canada, the 44 Victorian-era industrial brick buildings were repurposed in 2003 into a pedestrian-only arts and entertainment village. Today the cobblestone lanes are lined with over 70 galleries, cafés, restaurants, and boutiques, and the district hosts Toronto's beloved annual Christmas Market.",
                systemImage = "wineglass.fill",
                address = "55 Mill St, Toronto, ON M5A 3C4",
            ),
            Place(
                name = "Kensington Market",
                category = "Neighborhood",
                details = "Kensington Market is one of Toronto's most eclectic neighbourhoods — a pedestrian-friendly enclave west of Chinatown packed with independent shops, global street food vendors, and colourful murals. Originally a Jewish market in the early 20th century, it has evolved to reflect waves of Caribbean, South American, Portuguese, and Asian immigration. Every summer, Pedestrian Sundays close the streets to traffic, filling the lanes with cyclists, food carts, and live performances.",
                systemImage = "cart.fill",
                address = "Augusta Ave & Baldwin St, Toronto, ON M5T 2M3",
            ),
            Place(
                name = "St. Lawrence Market",
                category = "Market",
                details = "St. Lawrence Market has operated on this site since 1803 and was named the world's best food market by National Geographic Traveller in 2012. The south building operates Tuesday through Sunday with over 120 permanent vendors selling butcher meats, fresh fish, artisan cheeses, baked goods, and international prepared foods. A Saturday farmers' market in the north building draws local producers selling fresh produce, honey, and handmade items.",
                systemImage = "basket.fill",
                address = "93 Front St E, Toronto, ON M5E 1C3",
            ),
            Place(
                name = "Queen Street West",
                category = "Neighborhood",
                details = "Queen Street West is a long commercial strip that transitions from luxury retail near University Avenue through independent boutiques, vintage stores, and street-art galleries in the 'West Queen West' and Parkdale sections. The stretch around Trinity Bellwoods Park is known for independent cafés, design studios, and some of Toronto's most critically acclaimed restaurants. The corridor has been repeatedly named one of the world's coolest shopping streets by international travel media.",
                systemImage = "bag.fill",
                address = "Queen St W & Spadina Ave, Toronto, ON M6J 1E6",
            ),
            Place(
                name = "Chinatown",
                category = "Neighborhood",
                details = "Toronto's Chinatown along Spadina Avenue and Dundas Street West is one of North America's most densely packed Asian commercial districts, with authentic Cantonese, Hong Kong-style, and Vietnamese restaurants on every block. Chinese bakeries, bubble tea shops, herbal medicine stores, and produce markets operate alongside newer pan-Asian businesses. Weekend mornings are particularly lively, with sidewalk vendors and restaurants running full dim sum service.",
                systemImage = "takeoutbag.and.cup.and.straw.fill",
                address = "Spadina Ave & Dundas St W, Toronto, ON M5T 2M1",
            ),
            Place(
                name = "Little Italy",
                category = "Neighborhood",
                details = "Little Italy centres on College Street between Bathurst and Shaw, originally settled by Southern Italian immigrants in the early 1900s who brought espresso bars, fresh pasta shops, and bocce courts to the neighbourhood. Today it is one of Toronto's most popular evening destinations, with packed patios in summer, natural wine bars, and a mix of traditional Italian and modern fusion restaurants. The neighbourhood is also steps from The Annex and Bickford Park.",
                systemImage = "fork.knife",
                address = "College St & Clinton St, Toronto, ON M6G 1B7",
            ),
            Place(
                name = "The Beaches",
                category = "Neighborhood",
                details = "The Beaches neighbourhood stretches east from Woodbine Avenue along Queen Street East to Lake Ontario, anchored by a 3-kilometre sandy boardwalk and four public swimming beaches. The shoreline is backed by lifeguard-staffed areas, beach volleyball courts, and a running and cycling trail connecting to the wider waterfront path. Queen Street East in the Beaches has a distinctly relaxed, small-town character with independent cafés, bookshops, and boutiques.",
                systemImage = "beach.umbrella.fill",
                address = "Queen St E & Woodbine Ave, Toronto, ON M4E 1G7",
            ),
            Place(
                name = "Yorkville",
                category = "Neighborhood",
                details = "Yorkville was Toronto's bohemian music scene in the early 1960s, launching the careers of Joni Mitchell, Neil Young, and Gordon Lightfoot in small coffeehouses before redeveloping into the city's most prestigious retail district. The neighbourhood now hosts flagship boutiques for Hermès, Chanel, and Louis Vuitton, alongside independent galleries and five-star hotels. Each September during the Toronto International Film Festival, Yorkville becomes the epicentre of celebrity sightings and industry events.",
                systemImage = "star.circle.fill",
                address = "Cumberland St & Bay St, Toronto, ON M5R 1A6",
            ),
        )),
        PlaceSection(title = "Day Trips from the GTA", places = listOf(
            Place(
                name = "Niagara Falls",
                category = "Day Trip",
                details = "Niagara Falls is a collection of three waterfalls — the Horseshoe, American, and Bridal Veil Falls — straddling the Ontario-New York border and producing the highest flow rate of any waterfall in North America. The Niagara City Cruises boat tour brings visitors within metres of the base of the Horseshoe Falls, which drops over 50 metres and has carved a plunge pool 56 metres deep. The Journey Behind the Falls experience passes through tunnels in the bedrock to reach outdoor observation decks directly beside the cascade.",
                systemImage = "drop.fill",
                address = "6650 Niagara Pkwy, Niagara Falls, ON L2E 6T2",
            ),
            Place(
                name = "Niagara-on-the-Lake",
                category = "Day Trip",
                details = "Niagara-on-the-Lake is an immaculately preserved 19th-century town at the mouth of the Niagara River, widely regarded as the prettiest town in Canada. The town is home to the Shaw Festival — one of the world's leading theatre events — presenting works by George Bernard Shaw and his contemporaries at four venues each season from April to December. The surrounding wine region produces world-class Icewine, Pinot Noir, and Riesling from over 30 estate wineries within a 20-minute drive.",
                systemImage = "leaf.arrow.triangle.circlepath",
                address = "26 Queen St, Niagara-on-the-Lake, ON L0S 1J0",
            ),
            Place(
                name = "Scarborough Bluffs",
                category = "Day Trip",
                details = "The Scarborough Bluffs are a 15-kilometre chain of dramatic white and tan glacial cliffs rising up to 90 metres above Lake Ontario's eastern shoreline, formed over 12,000 years by wave erosion of glacial lake sediments. Bluffer's Park at the base of the bluffs provides the best vantage point, with a sandy beach, a marina, and trails through the wooded ravines that cut down to the water. The path along the top of the bluffs through Cathedral Bluffs Park offers sweeping panoramas across the lake toward Niagara.",
                systemImage = "mountain.2.fill",
                address = "1 Brimley Rd S, Toronto, ON M1M 3W3",
            ),
            Place(
                name = "Hamilton Waterfalls",
                category = "Day Trip",
                details = "Hamilton sits atop the Niagara Escarpment and contains over 100 waterfalls within city limits, earning it the nickname 'Waterfall Capital of the World.' Albion Falls, a 19-metre tiered limestone cascade, and Webster's Falls at 22 metres are the most visited, both reachable with short walks from parking lots. The Hamilton Waterfall Trail connects most falls along a 35-kilometre route that also links to the Bruce Trail, Canada's oldest and longest marked footpath.",
                systemImage = "drop.triangle.fill",
                address = "Albion Falls, Hamilton, ON L8K 5W4",
            ),
            Place(
                name = "Blue Mountain / Collingwood",
                category = "Day Trip",
                details = "Blue Mountain Resort in Collingwood is Ontario's largest ski and snowboard destination with 42 runs and a 364-metre vertical drop above Georgian Bay. In summer the resort transforms into an adventure hub with mountain biking, canyon zip lines, a treetop trekking course, and a beach club on Georgian Bay. The pedestrian village at the base of the hill has restaurants, boutiques, and a year-round outdoor events program.",
                systemImage = "figure.skiing.downhill",
                address = "190 Gord Canning Dr, The Blue Mountains, ON L9Y 3Z2",
            ),
            Place(
                name = "Wasaga Beach",
                category = "Day Trip",
                details = "Wasaga Beach on Georgian Bay's south shore holds the distinction of being the world's longest freshwater beach at 14 kilometres, with warm and shallow water that extends hundreds of metres from shore. The beach is divided into numbered sections from the lively Beach Area 1 near Mosley Street to the quieter eastern sections within Wasaga Beach Provincial Park. The park's western end protects a system of freshwater sand dunes — among the largest on the Great Lakes — along with hiking trails through regrowth forest.",
                systemImage = "sun.max.fill",
                address = "60 First St, Wasaga Beach, ON L9Z 2G1",
            ),
        )),
    )

    private val mississauga: List<PlaceSection> = listOf(
        PlaceSection(title = "Top Attractions", places = listOf(
            Place(
                name = "Absolute World Towers",
                category = "Landmark",
                details = "The two Absolute World condominiums — nicknamed the 'Marilyn Monroe Towers' for their curved, rotating floor plates — were designed by Beijing firm MAD Architects and completed in 2012 and 2013. The taller south tower at 56 storeys was voted Best Tall Building in the Americas by the Council on Tall Buildings and Urban Habitat in 2012, putting Mississauga on the global architectural map.",
                systemImage = "building.2.fill",
                imageName = "Mississauga",
                address = "50 Absolute Ave, Mississauga, ON L4Z 0A3",
            ),
            Place(
                name = "Square One Shopping Centre",
                category = "Shopping",
                details = "Square One Shopping Centre is one of Canada's three largest malls, with over 2.2 million square feet of retail space and more than 360 stores and restaurants anchoring downtown Mississauga's City Centre district. The mall serves as the terminus for several MiWay and GO Transit routes and is undergoing a major mixed-use expansion to add residential towers and public spaces.",
                systemImage = "bag.fill",
                imageName = "SquareOne",
                address = "100 City Centre Dr, Mississauga, ON L5B 2C9",
            ),
            Place(
                name = "Celebration Square",
                category = "Landmark",
                details = "Celebration Square is Mississauga's outdoor civic gathering space in City Centre, fronting the landmark Mississauga Civic Centre clock tower. The square hosts over 200 events annually including the popular Festival of Lights in winter, Canada Day celebrations, and a summer outdoor concert series.",
                systemImage = "flag.checkered",
                imageName = "CelebrationSquare",
                address = "300 City Centre Dr, Mississauga, ON L5B 0B3",
            ),
            Place(
                name = "Port Credit",
                category = "Neighborhood",
                details = "Port Credit is a charming waterfront village at the mouth of the Credit River on Lake Ontario, known for its marina, boardwalk, and lively patio restaurant scene. The village hosts several annual festivals including the Port Credit Busker Fest and the Southside Shuffle Blues & Jazz Festival, drawing crowds from across the GTA.",
                systemImage = "sailboat.fill",
                imageName = "PortCredit",
                address = "1 Port St E, Mississauga, ON L5G 4T1",
            ),
            Place(
                name = "Kariya Park",
                category = "Outdoors",
                details = "Kariya Park is a serene Japanese garden in the heart of Mississauga's City Centre, gifted by the city's sister city of Kariya, Japan, in 1992. The garden features a stone lantern, koi pond, pagoda, arched bridge, and seasonal cherry blossoms that attract photographers every spring.",
                systemImage = "leaf.fill",
                imageName = "KariyaPark",
                address = "270 Webb Dr, Mississauga, ON L5B 3Z2",
            ),
            Place(
                name = "Bradley Museum",
                category = "Museum",
                details = "The Bradley Museum is a heritage complex of three historic buildings on the Lake Ontario shoreline in Mississauga's Clarkson area, operated by the Mississauga Heritage Foundation. The 1830 log cabin and 1830s Bradley House recreate pioneer domestic life, while the nearby 1867 Anchorage farmhouse provides additional interpretation of 19th-century lakefront settlement.",
                systemImage = "building.columns.fill",
                imageName = "BradleyMuseum",
                address = "1620 Orr Rd, Mississauga, ON L5J 4T2",
            ),
        )),
        PlaceSection(title = "Local Spots", places = listOf(
            Place(
                name = "Streetsville",
                category = "Neighborhood",
                details = "Streetsville is one of Mississauga's original villages, retaining its historic small-town character along Queen Street South with heritage buildings, independent boutiques, cafés, and restaurants. The annual Streetsville Bread and Honey Festival, held every June since 1972, is one of the longest-running community festivals in Ontario.",
                systemImage = "house.fill",
                address = "253 Queen St S, Mississauga, ON L5M 1L6",
            ),
            Place(
                name = "The Riverwood Conservancy",
                category = "Outdoors",
                details = "The Riverwood Conservancy is a 60-hectare natural sanctuary along the Credit River in Mississauga's Erindale neighbourhood, blending restored heritage estate gardens with protected natural areas. The grounds include formal perennial gardens, restored meadows, and trail networks through a Carolinian forest along the Credit River valley.",
                systemImage = "leaf.arrow.circlepath",
                address = "4460 Riverwood Park Lane, Mississauga, ON L5C 2S7",
            ),
        )),
    )

    private val brampton: List<PlaceSection> = listOf(
        PlaceSection(title = "Top Attractions", places = listOf(
            Place(
                name = "Gage Park",
                category = "Outdoors",
                details = "Gage Park is the centrepiece of historic downtown Brampton, featuring formal rose gardens, a heritage bandshell for outdoor concerts, and a beloved trail-style outdoor skating rink in winter. The park hosts the annual Carabram multicultural festival and numerous community events throughout the warmer months.",
                systemImage = "leaf.fill",
                imageName = "GagePark",
                address = "45 Main St N, Brampton, ON L6X 1N3",
            ),
            Place(
                name = "Rose Theatre",
                category = "Arts & Culture",
                details = "The Rose Theatre is Brampton's premier 900-seat performing arts venue on Theatre Lane, presenting professional theatre, concerts, dance, and comedy from September through May. The facility also includes a 120-seat Studio Theatre for intimate productions and is the anchor of Brampton's growing cultural quarter.",
                systemImage = "theatermasks.fill",
                imageName = "RoseTheatre",
                address = "1 Theatre Lane, Brampton, ON L6V 0A3",
            ),
            Place(
                name = "Chinguacousy Park",
                category = "Outdoors",
                details = "Chinguacousy Park is a large multi-use recreational complex in northeast Brampton featuring a petting zoo, splash pad, paddleboat rentals, tennis courts, and a ski and snowboard tube hill operating in winter. The park was named for the Township of Chinguacousy, derived from an Ojibwe word meaning 'young pine tree,' and is one of the GTA's best family parks.",
                systemImage = "figure.walk",
                imageName = "ChinguacousyPark",
                address = "9050 Bramalea Rd, Brampton, ON L6S 5P9",
            ),
            Place(
                name = "PAMA (Peel Art Gallery, Museum & Archives)",
                category = "Museum",
                details = "PAMA occupies a restored 1867 county courthouse and 1906 jail in downtown Brampton, making its heritage buildings an exhibit in themselves. The gallery hosts rotating contemporary art exhibitions alongside permanent displays on the history of Peel Region, and the archives hold genealogical records and local history collections open to researchers.",
                systemImage = "building.columns.fill",
                imageName = "PAMA",
                address = "9 Wellington St E, Brampton, ON L6W 1Y1",
            ),
            Place(
                name = "Professor's Lake",
                category = "Outdoors",
                details = "Professor's Lake is a 66-acre man-made recreational lake in northeast Brampton, created in the 1960s as a gravel extraction site and now surrounded by a park with sandy beaches, boat rentals, and a fitness trail. The lake's warm, shallow water makes it popular for summer swimming and kayaking, and the adjacent parkland is used for year-round walking.",
                systemImage = "figure.sailing",
                imageName = "ProfessorsLake",
                address = "1700 N Park Dr, Brampton, ON L6S 4N5",
            ),
        )),
        PlaceSection(title = "Local Spots", places = listOf(
            Place(
                name = "Brampton Farmers' Market",
                category = "Market",
                details = "The Brampton Farmers' Market runs on Friday mornings from late May through October in downtown Brampton's Market Square, offering local produce, baked goods, preserves, and artisan crafts from dozens of regional vendors. It is one of Peel Region's oldest seasonal markets and a staple of downtown Brampton's summer calendar.",
                systemImage = "cart.fill",
                address = "9 George St N, Brampton, ON L6X 1R5",
            ),
            Place(
                name = "Downtown Brampton / Main Street",
                category = "Neighborhood",
                details = "Downtown Brampton is centred around Main Street North and Queen Street West, with a mix of heritage storefronts, independent restaurants, and civic institutions including Brampton City Hall and the Rose Theatre. The area is undergoing significant revitalization as part of a plan to increase residential density and cultural amenities in the city's historic core.",
                systemImage = "building.2.fill",
                address = "1 George St N, Brampton, ON L6X 1R5",
            ),
        )),
    )

    private val vaughan: List<PlaceSection> = listOf(
        PlaceSection(title = "Top Attractions", places = listOf(
            Place(
                name = "Canada's Wonderland",
                category = "Amusement Park",
                details = "Canada's Wonderland is the country's largest amusement park, opened in 1981 as Canada's first major theme park and now owned by Cedar Fair. The park features over 200 attractions including 17 roller coasters — among them Leviathan, once one of the world's tallest and fastest coasters — plus the Splash Works water park included with admission.",
                systemImage = "star.fill",
                imageName = "Vaughan",
                address = "1 Canada's Wonderland Dr, Vaughan, ON L6A 1S6",
            ),
            Place(
                name = "Vaughan Mills",
                category = "Shopping",
                details = "Vaughan Mills is a 1.3-million-square-foot outlet and value retail shopping centre with over 240 stores including major outlet brands, a Bass Pro Shops flagship, and entertainment tenants. The mall is directly adjacent to Canada's Wonderland, making the two a popular pairing for a full day trip from Toronto.",
                systemImage = "bag.fill",
                imageName = "VaughanMills",
                address = "1 Bass Pro Mills Dr, Vaughan, ON L4K 5W4",
            ),
            Place(
                name = "McMichael Canadian Art Collection",
                category = "Museum",
                details = "The McMichael Canadian Art Collection in Kleinburg village holds the largest dedicated collection of works by the Group of Seven and their contemporaries, along with significant Indigenous and Inuit art. The gallery's log-and-stone building sits in a woodland setting that consciously echoes the Canadian landscapes the Group of Seven immortalised in their paintings.",
                systemImage = "paintpalette.fill",
                imageName = "McMichael",
                address = "10365 Islington Ave, Kleinburg, ON L0J 1C0",
            ),
            Place(
                name = "Kortright Centre for Conservation",
                category = "Outdoors",
                details = "The Kortright Centre for Conservation is a 325-hectare nature centre in Woodbridge operated by the Toronto and Region Conservation Authority, offering guided nature programs, owl prowls, treetop trekking, and over 16 kilometres of forest and meadow trails. It is one of Ontario's leading environmental education facilities, running school and family programs throughout the year.",
                systemImage = "leaf.fill",
                imageName = "Kortright",
                address = "9550 Pine Valley Dr, Woodbridge, ON L4L 1A6",
            ),
            Place(
                name = "Boyd Conservation Area",
                category = "Outdoors",
                details = "Boyd Conservation Area is a 489-hectare park along the East Humber River in Woodbridge, popular for picnicking, hiking, cross-country skiing in winter, and fishing along the river corridor. The park's mature forest and river floodplain support diverse wildlife including great blue herons, white-tailed deer, and migratory songbirds.",
                systemImage = "tree.fill",
                imageName = "BoydConservation",
                address = "8739 Islington Ave, Woodbridge, ON L4L 1W4",
            ),
        )),
        PlaceSection(title = "Local Spots", places = listOf(
            Place(
                name = "Woodbridge",
                category = "Neighborhood",
                details = "Woodbridge is a historic village in southern Vaughan with deep Italian-Canadian roots, featuring a main street of espresso bars, Italian bakeries, and restaurants alongside boutique shops. The neighbourhood's annual Woodbridge Italian Festival draws visitors from across the GTA for live music, food, and cultural programming.",
                systemImage = "house.fill",
                address = "7600 Islington Ave, Woodbridge, ON L4L 1A6",
            ),
        )),
    )

    private val markham: List<PlaceSection> = listOf(
        PlaceSection(title = "Top Attractions", places = listOf(
            Place(
                name = "Main Street Unionville",
                category = "Neighborhood",
                details = "Main Street Unionville is a preserved 19th-century streetscape in the village of Unionville, with heritage commercial buildings dating to the 1860s housing antique shops, restaurants, and boutiques along a short, pedestrian-friendly strip. A historic millpond, walking bridge, and the Toogood Pond trail connect the main street to the surrounding natural setting.",
                systemImage = "building.2.fill",
                imageName = "MainStreetUnionville",
                address = "Main Street Unionville, Markham, ON L3R 2G5",
            ),
            Place(
                name = "Markham Museum",
                category = "Museum",
                details = "The Markham Museum is a living history site spread across 25 hectares, with over 30 heritage buildings relocated from across York Region and reconstructed to interpret 19th-century rural Ontario life. Re-enactors operate the buildings seasonally, and the museum hosts events including an annual fall fair and pioneer skills demonstrations.",
                systemImage = "building.columns.fill",
                imageName = "MarkhamMuseum",
                address = "9350 Markham Rd, Markham, ON L6E 0B9",
            ),
            Place(
                name = "Pacific Mall",
                category = "Shopping",
                details = "Pacific Mall is North America's largest indoor Asian shopping mall with over 450 stores and stalls under one roof, offering electronics, fashion, Asian cuisine, bubble tea, and hard-to-find imported goods. The mall serves as a commercial and cultural hub for the GTA's large East and Southeast Asian communities, and is especially busy on weekends.",
                systemImage = "bag.fill",
                imageName = "PacificMall",
                address = "4300 Steeles Ave E, Markham, ON L3R 0Y5",
            ),
            Place(
                name = "Toogood Pond Park",
                category = "Outdoors",
                details = "Toogood Pond is a scenic park surrounding a heritage millpond in Unionville, with a loop trail through mature trees, a historic dam structure, and abundant birdlife including nesting Canada geese. The park connects directly to the Main Street Unionville heritage district, making it a natural extension of the village walk.",
                systemImage = "leaf.fill",
                imageName = "ToogoodPond",
                address = "16 Toogood Pond, Unionville, ON L3R 6B3",
            ),
            Place(
                name = "Angus Glen",
                category = "Recreation",
                details = "Angus Glen Golf Club in northern Markham has hosted the RBC Canadian Open twice — in 2002 and 2007 — and the 2001 World Amateur Golf Championship, placing it among Canada's most prestigious golf facilities. The club features two 18-hole championship courses and is surrounded by trail networks through the Markham greenbelt.",
                systemImage = "figure.golf",
                imageName = "AngusGlen",
                address = "10080 Kennedy Rd, Markham, ON L6C 1N9",
            ),
        )),
    )

    private val richmondHill: List<PlaceSection> = listOf(
        PlaceSection(title = "Top Attractions", places = listOf(
            Place(
                name = "David Dunlap Observatory",
                category = "Attraction",
                details = "The David Dunlap Observatory in Richmond Hill houses Canada's largest optical telescope, a 1.88-metre reflector installed in 1935 that made important contributions to stellar spectroscopy and distance measurement. Designated a National Historic Site of Canada in 2022, the observatory now operates as a public science and heritage destination with regular stargazing evenings and guided tours.",
                systemImage = "sparkles",
                imageName = "DunlapObservatory",
                address = "123 Hillsview Dr, Richmond Hill, ON L4C 1T3",
            ),
            Place(
                name = "Lake Wilcox / Richmond Green Park",
                category = "Outdoors",
                details = "Lake Wilcox is a natural kettle lake in northern Richmond Hill, surrounded by trails and parkland including the Richmond Green Sports Centre and Park. The lake is a popular destination for kayaking, paddleboarding, and fishing, with a public beach and splash pad at the north end for summer recreation.",
                systemImage = "figure.walk",
                imageName = "LakeWilcox",
                address = "1300 Elgin Mills Rd E, Richmond Hill, ON L4S 1N4",
            ),
            Place(
                name = "Hillcrest Mall",
                category = "Shopping",
                details = "Hillcrest Mall is a regional shopping centre on Yonge Street in Richmond Hill, anchored by major department stores and featuring over 130 specialty retailers. The mall serves as the primary retail hub for northern York Region residents and is undergoing planned redevelopment to add mixed-use density.",
                systemImage = "bag.fill",
                imageName = "HillcrestMall",
                address = "9350 Yonge St, Richmond Hill, ON L4C 5G2",
            ),
            Place(
                name = "Bruce's Mill Conservation Area",
                category = "Outdoors",
                details = "Bruce's Mill Conservation Area in Gormley is a 263-hectare TRCA park best known for its annual Maple Syrup Festival each March, when visitors can watch the full sap-to-syrup process using both traditional and modern methods. The park also offers fishing in Bruce's Mill pond, hiking trails through mixed forest, and cross-country ski trails in winter.",
                systemImage = "tree.fill",
                imageName = "BrucesMill",
                address = "3291 Stouffville Rd, Gormley, ON L0H 1G0",
            ),
        )),
    )

    private val oakville: List<PlaceSection> = listOf(
        PlaceSection(title = "Top Attractions", places = listOf(
            Place(
                name = "Downtown Oakville & Lakeside Park",
                category = "Neighborhood",
                details = "Downtown Oakville centres on Lakeshore Road East and Colborne Street, a walkable heritage district with 19th-century commercial buildings housing independent restaurants, boutiques, and galleries steps from the harbour. Lakeside Park and the adjacent pier offer unobstructed views across Lake Ontario toward the Niagara Peninsula and, on clear days, the CN Tower on the horizon.",
                systemImage = "sailboat.fill",
                imageName = "Oakville",
                address = "120 Navy St, Oakville, ON L6J 2Z4",
            ),
            Place(
                name = "Oakville Harbour",
                category = "Outdoors",
                details = "Oakville Harbour is a working pleasure-craft marina at the mouth of Sixteen Mile Creek, one of the oldest harbour sites on Lake Ontario, used for commerce from the early 19th century. The harbour is surrounded by a waterfront walking trail and public parkland, with restaurants and cafés overlooking the docked sailboats and motor craft.",
                systemImage = "anchor.fill",
                imageName = "Oakville",
                address = "50 Lakeshore Rd W, Oakville, ON L6K 1C6",
            ),
            Place(
                name = "Gairloch Gardens",
                category = "Outdoors",
                details = "Gairloch Gardens is a lakeside estate park on Lakeshore Road East, featuring formal perennial gardens, a rose garden, a lakefront lawn, and the Oakville Galleries at Gairloch — a municipal art gallery housed in the 1927 estate house. The gardens overlook Lake Ontario with the Toronto skyline faintly visible on the northern horizon.",
                systemImage = "leaf.fill",
                imageName = "GairlochGardens",
                address = "1306 Lakeshore Rd E, Oakville, ON L6J 1L6",
            ),
            Place(
                name = "Bronte Village & Marina",
                category = "Neighborhood",
                details = "Bronte Village is a historic fishing community on Lake Ontario at the mouth of Bronte Creek, now a popular patio and marina destination with a public waterfront promenade and parks. The Bronte Heritage Waterfront Park and pier are the setting for the annual Bronte Harbour Waterfront Festival each summer.",
                systemImage = "house.fill",
                imageName = "BronteVillage",
                address = "2340 Ontario St, Oakville, ON L6L 1P7",
            ),
            Place(
                name = "Oakville Museum at Erchless Estate",
                category = "Museum",
                details = "The Oakville Museum occupies Erchless Estate, the 1858 Italianate house of Oakville's founding Chisholm family, set on the harbour's edge. The museum's collection covers the town's evolution from a pioneer lumber and grain port to its current identity as one of Ontario's most affluent communities.",
                systemImage = "building.columns.fill",
                imageName = "ErchlessEstate",
                address = "8 Navy St, Oakville, ON L6J 2Y1",
            ),
        )),
        PlaceSection(title = "Local Spots", places = listOf(
            Place(
                name = "Kerr Village",
                category = "Neighborhood",
                details = "Kerr Village is a revitalized retail strip along Kerr Street in west Oakville, with a concentration of independent restaurants, antique shops, specialty grocery stores, and cafés that give it a village character distinct from Oakville's more upscale core. Pedestrian streetscaping improvements in recent years have made it one of the GTA's more pleasant neighbourhood commercial strips.",
                systemImage = "cart.fill",
                address = "190 Kerr St, Oakville, ON L6K 3A6",
            ),
        )),
    )

    private val burlington: List<PlaceSection> = listOf(
        PlaceSection(title = "Top Attractions", places = listOf(
            Place(
                name = "Royal Botanical Gardens",
                category = "Outdoors",
                details = "The Royal Botanical Gardens spans 1,100 hectares across Burlington and Hamilton, making it Canada's largest botanical garden and one of the largest in the world by area. Five distinct garden areas — including the renowned rose and rock gardens — are connected by 27 kilometres of nature trails through the Niagara Escarpment and Cootes Paradise marsh.",
                systemImage = "leaf.fill",
                imageName = "RoyalBotanicalGardens",
                address = "680 Plains Rd W, Burlington, ON L7T 4H4",
            ),
            Place(
                name = "Spencer Smith Park",
                category = "Outdoors",
                details = "Spencer Smith Park is a sweeping lakefront park in downtown Burlington running along Lakeshore Road, with open lawns, public art installations, a splash pad, and the Brant Street Pier extending 137 metres into Lake Ontario. The park is the annual site of the Burlington Sound of Music Festival, the largest free music festival in Canada.",
                systemImage = "figure.walk",
                imageName = "Burlington",
                address = "1400 Lakeshore Rd, Burlington, ON L7S 1A1",
            ),
            Place(
                name = "Burlington Beach & Pier",
                category = "Outdoors",
                details = "The Burlington Waterfront Trail connects Spencer Smith Park to the Beachway Park along a narrow spit of land between Lake Ontario and LaSalle Park Lagoon, with a sandy beach that is one of the most accessible swimming spots in the region. The Brant Street Pier, opened in 2013, offers an elevated platform 137 metres out over the lake — a popular spot for sunrise and sunset photography.",
                systemImage = "beach.umbrella.fill",
                imageName = "BrantStreetPier",
                address = "10 Brant St, Burlington, ON L7R 2G9",
            ),
            Place(
                name = "Rattlesnake Point Conservation Area",
                category = "Outdoors",
                details = "Rattlesnake Point is a dramatic section of the Niagara Escarpment near Milton, where dolomite cliffs rise 30 metres above the surrounding plains, offering some of the best traditional rock climbing in Ontario and panoramic views of the Halton countryside. Hikers can walk the cliff-edge trail for several kilometres, with connections to the Bruce Trail.",
                systemImage = "mountain.2.fill",
                imageName = "RattlesnakePoint",
                address = "7200 Appleby Line, Milton, ON L9T 2Y3",
            ),
            Place(
                name = "Mapleview Shopping Centre",
                category = "Shopping",
                details = "Mapleview Shopping Centre is Burlington's largest mall, anchored by major department stores and featuring over 150 specialty retailers along Maple Avenue near Fairview Street. The mall serves as the primary shopping hub for Burlington and south Halton Region residents.",
                systemImage = "bag.fill",
                imageName = "Mapleview",
                address = "900 Maple Ave, Burlington, ON L7S 2J8",
            ),
        )),
        PlaceSection(title = "Local Spots", places = listOf(
            Place(
                name = "Downtown Burlington / Brant Street",
                category = "Neighborhood",
                details = "Burlington's Brant Street shopping district stretches south from New Street through a mix of locally owned restaurants, boutiques, and services in a walkable downtown core that connects directly to Spencer Smith Park and the lake. The area has benefited from significant public investment in recent years with new streetscaping and pedestrian lighting improvements.",
                systemImage = "house.fill",
                address = "442 Brant St, Burlington, ON L7R 2G4",
            ),
        )),
    )

    private val ajax: List<PlaceSection> = listOf(
        PlaceSection(title = "Top Attractions", places = listOf(
            Place(
                name = "Ajax Waterfront Trail",
                category = "Outdoors",
                details = "The Ajax Waterfront Trail follows the Lake Ontario shoreline through a series of parks and conservation areas that form part of the Greater Lakes Waterfront Trail network. The trail passes through Rotary Park, Lakeside Park, and Carruthers Creek Wildlife Area, offering lake views and sightings of the Toronto skyline to the west.",
                systemImage = "figure.walk",
                imageName = "Ajax",
                address = "315 Harwood Ave S, Ajax, ON L1S 2J1",
            ),
            Place(
                name = "Rotary Park",
                category = "Outdoors",
                details = "Rotary Park sits at the foot of Harwood Avenue South on Lake Ontario, with picnic shelters, a children's playground, open lawns, and access to the lakefront trail system. The park is a popular spot for fishing along the lake shore and provides one of Ajax's most accessible connections to the waterfront.",
                systemImage = "leaf.fill",
                imageName = "RotaryPark",
                address = "315 Harwood Ave S, Ajax, ON L1S 2J1",
            ),
            Place(
                name = "Paradise Park",
                category = "Outdoors",
                details = "Paradise Park is a multi-use community recreation area in central Ajax with baseball diamonds, soccer fields, a hockey rink, and extensive trail connections through the adjacent Duffins Creek valley. The park provides a natural green corridor through the middle of Ajax's residential neighbourhoods.",
                systemImage = "tree.fill",
                address = "100 Church St N, Ajax, ON L1T 3A9",
            ),
            Place(
                name = "Ajax Community Centre",
                category = "Recreation",
                details = "The Ajax Community Centre is the town's primary recreation facility, featuring twin ice pads, a six-lane lap pool, fitness studios, and multipurpose rooms hosting programs for all ages year-round. The facility is adjacent to Centennial Park and the Ajax Public Library.",
                systemImage = "sportscourt.fill",
                address = "75 Centennial Rd, Ajax, ON L1Z 1E3",
            ),
        )),
    )

    private val oshawa: List<PlaceSection> = listOf(
        PlaceSection(title = "Top Attractions", places = listOf(
            Place(
                name = "Parkwood National Historic Site",
                category = "Historic Site",
                details = "Parkwood is the 55-room estate of Robert Samuel McLaughlin — founder of General Motors of Canada — built between 1917 and 1929 in Oshawa. Designated a National Historic Site, the property includes the main house with original furnishings, a billiards room, greenhouses, and nine hectares of formal gardens, and has served as a film location for productions including 'Billy Madison' and 'Chicago.'",
                systemImage = "building.columns.fill",
                imageName = "Oshawa",
                address = "270 Euclid St, Oshawa, ON L1G 3S8",
            ),
            Place(
                name = "Lakeview Park",
                category = "Outdoors",
                details = "Lakeview Park is Oshawa's primary waterfront destination, with a sand beach, splash pad, paddle boat rentals, a rose garden, and picnic facilities along Lake Ontario. The park hosts Oshawa's Canada Day celebrations and the annual Fiesta Week multicultural event each summer.",
                systemImage = "beach.umbrella.fill",
                imageName = "LakeviewPark",
                address = "100 Lakeview Park Ave, Oshawa, ON L1H 3X6",
            ),
            Place(
                name = "Canadian Automotive Museum",
                category = "Museum",
                details = "The Canadian Automotive Museum in downtown Oshawa celebrates the city's identity as the birthplace of General Motors of Canada, with over 65 historic and vintage vehicles dating from 1898 to the modern era. The collection includes a 1908 McLaughlin Model F — the first car built in Oshawa — alongside significant GM Canada milestones and interactive displays on automotive history.",
                systemImage = "car.fill",
                imageName = "AutomotiveMuseum",
                address = "99 Simcoe St S, Oshawa, ON L1H 4G7",
            ),
            Place(
                name = "Oshawa Valley Botanical Gardens",
                category = "Outdoors",
                details = "The Oshawa Valley Botanical Gardens is a curated public garden along Oshawa Creek in Memorial Park, featuring seasonal plantings, a heritage rose collection, a gazebo, and walking paths through manicured grounds. Maintained by the Oshawa Horticultural Society, the gardens are most spectacular from late May through September.",
                systemImage = "leaf.fill",
                imageName = "OshawaBotanicalGardens",
                address = "155 Bond St W, Oshawa, ON L1G 1A2",
            ),
        )),
    )

}
