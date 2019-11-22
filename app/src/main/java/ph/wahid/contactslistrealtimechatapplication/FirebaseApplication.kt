package ph.wahid.contactslistrealtimechatapplication

import android.app.Application
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import ph.wahid.contactslistrealtimechatapplication.data.firebase.FirebaseSource
import ph.wahid.contactslistrealtimechatapplication.data.repositories.UserRepository
import ph.wahid.contactslistrealtimechatapplication.databinding.ActivityLoginBinding.bind
import ph.wahid.contactslistrealtimechatapplication.ui.auth.AuthViewModelFactory

class FirebaseApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@FirebaseApplication))

        bind() from singleton { FirebaseSource() }
        bind() from singleton { UserRepository(instance()) }
        bind() from provider { AuthViewModelFactory(instance()) }
        //bind() from provider { HomeViewModelFactory(instance()) }

    }
}