package com.arvind.bottomnavwithsidenav.view.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.arvind.bottomnavwithsidenav.R
import com.arvind.bottomnavwithsidenav.databinding.ActivityMainBinding
import com.arvind.bottomnavwithsidenav.viewmodel.home.HomeViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_BottomNavWithSideNav)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel
        initViews(binding)
        observeNavElements(binding, navHostFragment.navController)
    }


    private fun initViews(binding: ActivityMainBinding) {
        navController = findNavController(R.id.nav_host_fragment)
        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment?
            ?: return

        with(navHostFragment.navController) {
            appBarConfiguration = AppBarConfiguration(graph)
            setupActionBarWithNavController(this, appBarConfiguration)
        }

    }

    private fun observeNavElements(binding: ActivityMainBinding, navController: NavController) {
        navController.addOnDestinationChangedListener { _, destination, _ ->

            when (destination.id) {

                R.id.welcomeFragment -> {
                    supportActionBar!!.setDisplayShowTitleEnabled(false)
                    hideBothNavigation()
                }

                R.id.SignInFragment -> {
                    supportActionBar!!.setDisplayShowTitleEnabled(true)
                    hideBothNavigation()
                    showToolbarNavigation()

                }

                R.id.SignUpFragment -> {
                    supportActionBar!!.setDisplayShowTitleEnabled(true)
                    hideBothNavigation()
                    showToolbarNavigation()
                }

                R.id.otpFragment -> {
                    supportActionBar!!.setDisplayShowTitleEnabled(true)
                    hideBothNavigation()
                    showToolbarNavigation()
                }

                else -> {
                    showBothNavigation()
                    supportActionBar!!.setDisplayShowTitleEnabled(true)
                }

            }
        }

        binding.navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.profileFragment -> {
                    binding.drawerLayout.closeDrawers()
                    navController.navigate(R.id.profileFragment)
                    true
                }

                R.id.action_invite_friends_mode -> {
                    shareMode()
                    true
                }
                R.id.helpFragment -> {
                    binding.drawerLayout.closeDrawers()
                    navController.navigate(R.id.helpFragment)
                    true
                }

                R.id.aboutUsFragment -> {
                    binding.drawerLayout.closeDrawers()
                    navController.navigate(R.id.aboutUsFragment)
                    true
                }

                R.id.settingsFragment -> {
                    binding.drawerLayout.closeDrawers()
                    navController.navigate(R.id.settingsFragment)
                    true
                }
                R.id.logoutFragment -> {
                    logout()
                    true
                }
                else -> {
                    false
                }
            }
        }

        binding.bottomNavView.setupWithNavController(navController)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.dashboardFragment,
                R.id.notificationsFragment
            ),
            binding.drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)

    }

    private fun showToolbarNavigation() {
        binding.toolbar.visibility = View.VISIBLE
    }

    private fun hideBothNavigation() {
        binding.bottomNavView.visibility = View.GONE
        binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        binding.toolbar.visibility = View.GONE
    }

    private fun showBothNavigation() {
        binding.toolbar.visibility = View.VISIBLE
        binding.bottomNavView.visibility = View.VISIBLE
        binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)

    }


    private fun setupNavControl() {
        binding.navView.setupWithNavController(navController)
        binding.bottomNavView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    //bottom nav
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(navHostFragment.navController) ||
                super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    private fun shareMode() {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }

    private fun logout() {
        MaterialAlertDialogBuilder(
            this,
            R.style.Theme_BottomNavWithSideNav_Dialog_Alert
        ).setTitle(this.resources.getString(R.string.logout))
            .setMessage(this.resources.getString(R.string.would_you_like_to_logout))
            .setPositiveButton(
                this.resources.getString(R.string.logout_ok)
            )
            { dialog, which ->
                binding.drawerLayout.closeDrawers()
                navHostFragment.navController.navigate(R.id.SignInFragment)
            }.setNegativeButton(
                this.resources.getString(R.string.cancel)
            ) { dialog, which -> dialog.cancel() }.show()
    }
}