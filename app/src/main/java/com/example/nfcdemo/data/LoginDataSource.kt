package com.example.nfcdemo.data

import com.example.nfcdemo.data.model.LoggedInUser
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    fun login(userId: String, password: String): Result<LoggedInUser> {
        try {
            // TODO: displayName:"김하연" -> database의 username으로
            val fakeUser = LoggedInUser(java.util.UUID.randomUUID().toString(), "김하연", userId)
            return Result.Success(fakeUser)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}