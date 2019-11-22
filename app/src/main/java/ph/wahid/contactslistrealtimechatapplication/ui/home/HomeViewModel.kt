package ph.wahid.contactslistrealtimechatapplication.ui.home

import android.view.View
import androidx.lifecycle.ViewModel
import ph.wahid.contactslistrealtimechatapplication.data.repositories.UserRepository
import ph.wahid.contactslistrealtimechatapplication.utils.startLoginActivity

class HomeViewModel(private val repository: UserRepository) : ViewModel() {

    val user by lazy {
        repository.currentUser()
    }

    fun logout(view: View){
        repository.logout()
        view.context.startLoginActivity()
    }
}