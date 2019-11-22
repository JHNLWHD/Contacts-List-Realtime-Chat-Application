package ph.wahid.contactslistrealtimechatapplication.ui.auth

interface AuthListener {
    fun onStarted()
    fun onSuccess()
    fun onFailure(message: String)
}