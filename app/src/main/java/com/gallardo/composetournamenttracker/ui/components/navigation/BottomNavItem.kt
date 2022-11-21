package com.gallardo.composetournamenttracker.ui.components.navigation

import com.gallardo.composetournamenttracker.R

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){
    object Groups : BottomNavItem("Groups", R.drawable.ic_groups,"groups")
    object Matches: BottomNavItem("Matches",R.drawable.ic_matches,"matches")
    object Brackets: BottomNavItem("Brackets",R.drawable.ic_brackets,"brackets")
    object Live: BottomNavItem("Live",R.drawable.ic_live,"live")
}