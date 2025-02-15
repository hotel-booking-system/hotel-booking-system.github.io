package br.com.creativeexperience.book_now.security.filter;

import jakarta.annotation.Nonnull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
public class CsrfCookieFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(@Nonnull HttpServletRequest request,
                                    @Nonnull HttpServletResponse response,
                                    @Nonnull FilterChain filterChain)
            throws ServletException, IOException {

        CsrfToken csrfToken = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
        if (csrfToken != null) {
            log.info("CSRF token obtido: {}", csrfToken.getToken());
            if (csrfToken.getHeaderName() != null) {
                log.info("Definindo cabeçalho CSRF: {} com token", csrfToken.getHeaderName());
                response.setHeader(csrfToken.getHeaderName(), csrfToken.getToken());
            }
        } else {
            log.warn("CSRF token não encontrado na requisição");
        }
        filterChain.doFilter(request, response);
    }

}