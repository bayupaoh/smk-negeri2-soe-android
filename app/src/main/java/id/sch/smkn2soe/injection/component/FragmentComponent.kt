package id.sch.smkn2soe.injection.component

import id.sch.smkn2soe.injection.PerFragment
import id.sch.smkn2soe.injection.module.FragmentModule
import dagger.Subcomponent

/**
 * This component inject dependencies to all Fragments across the application
 */
@PerFragment
@Subcomponent(modules = arrayOf(FragmentModule::class))
interface FragmentComponent