package com.example.igdb_api_based_android_app.model

import com.example.igdb_api_based_android_app.R

enum class TagType(val stringRes: Int, val iconRes: Int) {
    PEGI_3(R.string.PEGI_3, R.drawable.icons8_pegi_3),
    PEGI_7(R.string.PEGI_7, R.drawable.icons8_pegi_7),
    PEGI_12(R.string.PEGI_12, R.drawable.icons8_pegi_12),
    PEGI_16(R.string.PEGI_16, R.drawable.icons8_pegi_16),
    PEGI_18(R.string.PEGI_18, R.drawable.icons8_pegi_18),
    PEGI_BAD_LANGUAGE(R.string.PEGI_BAD_LANGUAGE, R.drawable.icons8_pegi_bad_language),
    PEGI_DISCRIMINATION(R.string.PEGI_DISCRIMINATION, R.drawable.icons8_pegi_discrimination),
    PEGI_DRUGS(R.string.PEGI_DRUGS, R.drawable.icons8_pegi_drugs),
    PEGI_FEAR(R.string.PEGI_FEAR, R.drawable.icons8_pegi_fear_and_horror),
    PEGI_GAMBLING(R.string.PEGI_GAMBLING, R.drawable.icons8_pegi_gambling),
    PEGI_HORROR(R.string.PEGI_HORROR, R.drawable.icons8_pegi_fear_and_horror),
    PEGI_IN_GAME_PURCHASES(R.string.PEGI_IN_GAME_PURCHASES, R.drawable.icons8_pegi_in_game_purchases),
    PEGI_ONLINE(R.string.PEGI_ONLINE, R.drawable.icons8_pegi_online),
    PEGI_SEX(R.string.PEGI_SEX, R.drawable.icons8_pegi_sex),
    PEGI_VIOLENCE(R.string.PEGI_VIOLENCE, R.drawable.icons8_pegi_violence)
}

data class Tag(
    val id: Int,
    val type: TagType
)