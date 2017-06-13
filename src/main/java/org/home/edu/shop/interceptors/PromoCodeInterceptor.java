package org.home.edu.shop.interceptors;

import lombok.Data;
import lombok.extern.log4j.Log4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by SweetHome on 11.06.2017.
 */
@Data
@Log4j
public class PromoCodeInterceptor extends HandlerInterceptorAdapter {

    private String promoCode;
    private String errorRedirect;
    private String offerRedirect;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String givenPromo = request.getParameter("promo");
        if (promoCode.equals(givenPromo)) {
            log.info("Context Path: " + request.getContextPath());
            response.sendRedirect(request.getContextPath() + "/" + offerRedirect);
        } else {
            response.sendRedirect(errorRedirect);
        }
        return false;
    }
}
