package com.zuul.fitler;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: tianchao
 * @Date: 2019/10/11 20:56
 * @Description:
 */
@Component
@Slf4j
public class LoginFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        //FilterConstants.PRE_DECORATION_FILTER_ORDER 处理请求头
        return FilterConstants.PRE_DECORATION_FILTER_ORDER-1;
    }

    @Override
    public boolean shouldFilter() {
        //要不要过滤
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //1获取请求的参数
        RequestContext ctx = RequestContext.getCurrentContext();
        final HttpServletRequest request = ctx.getRequest();
        //2判断是否存在
        String parameter = request.getParameter("access-token");
        //3不存在，未登录，则拦截
        if(StringUtils.isBlank(parameter)){
            ctx.setSendZuulResponse(false);
            //返回403
            ctx.setResponseStatusCode(HttpStatus.FORBIDDEN.value());
        }
        return null;
    }
}
