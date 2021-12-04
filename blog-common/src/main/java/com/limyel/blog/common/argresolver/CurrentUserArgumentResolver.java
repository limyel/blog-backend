package com.limyel.blog.common.argresolver;//package com.limyel.blog.common.argresolver;
//
//import com.limyel.blog.util.JwtUtil;
//import com.limyel.blog.common.annotation.CurrentUser;
//import com.limyel.blog.entity.User;
//import com.limyel.blog.exception.InvalidTokenException;
//import com.limyel.blog.exception.blogException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.MethodParameter;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.support.WebDataBinderFactory;
//import org.springframework.web.context.request.NativeWebRequest;
//import org.springframework.web.method.support.HandlerMethodArgumentResolver;
//import org.springframework.web.method.support.ModelAndViewContainer;
//
///**
// * 当前用户参数解析
// */
//@Component
//public class CurrentUserArgumentResolver implements HandlerMethodArgumentResolver {
//
//    @Autowired
//    private JwtUtil jwtUtil;
//
//    @Override
//    public boolean supportsParameter(MethodParameter methodParameter) {
//        CurrentUser currentUser = methodParameter.getParameterAnnotation(CurrentUser.class);
//        return currentUser != null;
//    }
//
//    @Override
//    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws blogException {
//        String authorizationHeader = nativeWebRequest.getHeader("Authorization");
//
//        // 当前不是登录状态
//        if (authorizationHeader == null) {
//            return null;
//        }
//
//        // 获取 jwt token
//        String token = authorizationHeader.split(" ")[1];
//
//        if (token.equals("undefined")) {
//            throw new InvalidTokenException();
//        }
//
//        User user = jwtUtil.parseJWT(token);
//
//        return user;
//    }
//}
