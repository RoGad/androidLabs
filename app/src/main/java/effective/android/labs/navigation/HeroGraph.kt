package effective.android.labs.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import effective.android.labs.presentation.screens.heroInfoScreen.HeroInfoScreen
import effective.android.labs.presentation.screens.mainScreen.HeroSelectionScreen
import effective.android.labs.presentation.viewModel.HeroSelectionViewModel

@Composable
fun HeroGraph(viewModel: HeroSelectionViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "heroSelection") {
        composable("heroSelection") {
            HeroSelectionScreen(
                viewModel = viewModel,
                onHeroClick = { hero ->
                    navController.navigate("heroInfo/${hero.name}")
                }
            )
        }
        composable(
            "heroInfo/{heroName}",
            arguments = listOf(navArgument("heroName") { type = NavType.StringType })
        ) { backStackEntry ->
            val heroName = backStackEntry.arguments?.getString("heroName")
            val hero = viewModel.heroes.find { it.name == heroName }
            hero?.let {
                HeroInfoScreen(
                    heroInfo = it,
                    onBackClick = { navController.popBackStack() }
                )
            }
        }
    }
}