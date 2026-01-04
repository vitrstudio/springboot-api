package studio.vitr.springboot.api.config

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.User
import org.springframework.web.filter.OncePerRequestFilter
import studio.vitr.springboot.api.constants.Authorities.USER
import studio.vitr.springboot.api.constants.Constants.BEARER
import studio.vitr.springboot.api.constants.Headers.AUTHORIZATION
import studio.vitr.springboot.api.constants.Properties.ACCESS_TOKEN
import studio.vitr.springboot.api.errors.InvalidParameter
import studio.vitr.springboot.api.service.AuthenticationService
import studio.vitr.springboot.api.service.UserService

class JwtAuthenticationFilter(
    private val authenticationService: AuthenticationService,
    private val userService: UserService,
) : OncePerRequestFilter() {

    override fun doFilterInternal(req: HttpServletRequest, res: HttpServletResponse, chain: FilterChain) {
        authenticateUser(req)
        chain.doFilter(req, res)
    }

    private fun authenticateUser(request: HttpServletRequest) = request.getHeader(AUTHORIZATION)
        ?.takeIf { it.startsWith(BEARER) }
        ?.substring(BEARER.length)
        ?.also { authenticationService.validateAccessToken(it) }
        ?.let { authenticationService.getUserId(it) }
        ?.let { userService.get(it) }
        ?.let { userDetails(it) }
        ?.let { UsernamePasswordAuthenticationToken(it, null, it.authorities) }
        ?.also { SecurityContextHolder.getContext().authentication = it }
        ?: throw InvalidParameter(ACCESS_TOKEN)

    private fun userDetails(user: studio.vitr.springboot.api.model.User) = User.builder()
        .username(user.idStr())
        .password(user.password)
        .authorities(USER)
        .build()
}
