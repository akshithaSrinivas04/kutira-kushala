package com.kutira.app.data

object SampleData {
    val businesses: List<Business> = listOf(
        Business(
            id = "b1",
            name = "Lakshmi Basket Weavers",
            ownerName = "Lakshmi Devi & Family",
            skillArea = "Bamboo Basket Weaving",
            location = "Channapatna, Karnataka",
            phone = "+919876543210",
            category = Category.CRAFT,
            emoji = "🧺",
            description = "Three generations of bamboo weavers. We hand-craft baskets used for produce, storage and home decor. Family of 5 weavers working from home workshop.",
            products = listOf(
                Product("p1", "Round Storage Basket", "Medium round basket, 12 inch", 80, "piece", "🧺"),
                Product("p2", "Produce Carrier", "Large oval basket with handles", 140, "piece", "🪣"),
                Product("p3", "Decor Tray", "Flat woven tray, natural finish", 95, "piece", "🍯")
            ),
            capacityUnits = 500,
            capacityPeriod = "this week",
            readyToTake = true
        ),
        Business(
            id = "b2",
            name = "Saraswati Agarbatti Works",
            ownerName = "Saraswati Bai",
            skillArea = "Agarbatti Rolling",
            location = "Mysuru, Karnataka",
            phone = "+919812345678",
            category = Category.INCENSE,
            emoji = "🕯",
            description = "Hand-rolled agarbatti made with traditional sandalwood and jasmine fragrance. Women-led collective of 8 rollers.",
            products = listOf(
                Product("p4", "Sandalwood Sticks", "Pack of 100 sticks", 45, "pack", "🕯"),
                Product("p5", "Jasmine Sticks", "Pack of 100 sticks", 50, "pack", "🌼"),
                Product("p6", "Mixed Pack", "Assorted fragrances, 200 sticks", 95, "pack", "🌸")
            ),
            capacityUnits = 2000,
            capacityPeriod = "per week",
            readyToTake = true
        ),
        Business(
            id = "b3",
            name = "Annapurna Papad Makers",
            ownerName = "Annapurna SHG",
            skillArea = "Papad & Pickles",
            location = "Hubli, Karnataka",
            phone = "+919823456789",
            category = Category.FOOD,
            emoji = "🍛",
            description = "Self-help group of 12 women making urad dal papad, masala papad and traditional pickles using family recipes.",
            products = listOf(
                Product("p7", "Urad Papad", "1 kg pack, sun-dried", 220, "kg", "🫓"),
                Product("p8", "Masala Papad", "1 kg pack with spice mix", 240, "kg", "🌶"),
                Product("p9", "Mango Pickle", "500g jar, traditional recipe", 180, "jar", "🥭")
            ),
            capacityUnits = 200,
            capacityPeriod = "this month",
            readyToTake = false
        ),
        Business(
            id = "b4",
            name = "Kamala Handlooms",
            ownerName = "Kamala & Daughters",
            skillArea = "Cotton Handloom Weaving",
            location = "Ilkal, Karnataka",
            phone = "+919834567890",
            category = Category.TEXTILE,
            emoji = "🧶",
            description = "Traditional Ilkal saree and stole weavers. Natural cotton dyed with vegetable colours. Three looms running daily.",
            products = listOf(
                Product("p10", "Cotton Stole", "Hand-woven, 6 colours", 320, "piece", "🧣"),
                Product("p11", "Table Runner", "200x35 cm, natural dye", 410, "piece", "🪡"),
                Product("p12", "Ilkal Saree", "Pure cotton, traditional motif", 1800, "piece", "👗")
            ),
            capacityUnits = 40,
            capacityPeriod = "this month",
            readyToTake = true
        ),
        Business(
            id = "b5",
            name = "Mitti Pottery Works",
            ownerName = "Ramesh Kumhar",
            skillArea = "Terracotta Pottery",
            location = "Bidar, Karnataka",
            phone = "+919845678901",
            category = Category.POTTERY,
            emoji = "🏺",
            description = "Wheel-thrown terracotta pots, diyas and planters. Wood-fired kiln in family courtyard.",
            products = listOf(
                Product("p13", "Terracotta Diya", "Pack of 20, hand-finished", 60, "pack", "🪔"),
                Product("p14", "Planter Pot", "Medium 8-inch, drainage hole", 110, "piece", "🪴"),
                Product("p15", "Water Pot (Matka)", "5 litre, traditional shape", 220, "piece", "🏺")
            ),
            capacityUnits = 300,
            capacityPeriod = "this week",
            readyToTake = true
        )
    )
}
