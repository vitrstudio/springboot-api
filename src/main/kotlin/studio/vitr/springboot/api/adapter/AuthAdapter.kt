package studio.vitr.springboot.api.adapter

import org.springframework.stereotype.Component
import studio.vitr.springboot.api.model.Session
import studio.vitr.springboot.api.model.api.RefreshTokenResponse
import studio.vitr.springboot.api.model.api.SignInResponse

@Component
class AuthAdapter {

    fun toSignUpResponse(s: Session) = SignInResponse(
        accessToken = s.accessToken,
        refreshToken = s.refreshToken,
    )

    fun toSignInResponse(s: Session) = SignInResponse(
        accessToken = s.accessToken,
        refreshToken = s.refreshToken,
    )

    fun toRefreshTokenResponse(s: Session) = RefreshTokenResponse(accessToken = s.accessToken)
}