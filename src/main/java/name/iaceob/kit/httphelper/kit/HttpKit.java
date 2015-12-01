package name.iaceob.kit.httphelper.kit;

import name.iaceob.kit.httphelper.common.HttpConst;
import name.iaceob.kit.httphelper.config.HttpConfig;
import name.iaceob.kit.httphelper.conn.HttpConnection;
import name.iaceob.kit.httphelper.conn.HttpConnectionBuilder;
import name.iaceob.kit.httphelper.entity.HttpEntity;
import name.iaceob.kit.httphelper.entity.ProxyEntity;
import name.iaceob.kit.httphelper.http.HttpReq;
import name.iaceob.kit.httphelper.restful.HttpMethod;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cox on 2015/11/27.
 */
public class HttpKit {


    public static HttpEntity get(String url, Map<String, String> paras, Map<String, String> header,
                                 ProxyEntity proxy, Charset charset, Integer connectTimeout,
                                 Integer readTimeout, Boolean autoDetectCharset) {
        try {
            HttpConfig config = HttpConfig.me().setConnectTimeout(connectTimeout)
                    .setReadTimeout(readTimeout).setCharset(charset).setAutoDetectCharset(autoDetectCharset);
            HttpConnectionBuilder hb = HttpConnectionBuilder.create().setConfig(config);
            if (proxy != null) hb.setProxy(proxy);
            HttpConnection hc = hb.build();
            HttpReq req = new HttpReq(HttpMethod.GET, url);
            if (paras!=null) req.setParas(paras);
            if (header!=null) req.setHeader(header);
            return hc.exec(req);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static HttpEntity post(String url, Map<String, String> paras, String data, Map<String, String> header,
                                  ProxyEntity proxy, Charset charset, Integer connectTimeout, Integer readTimeout,
                                  Boolean autoDetectCharset) {
        try {
            HttpConfig config = HttpConfig.me().setConnectTimeout(connectTimeout)
                    .setReadTimeout(readTimeout).setCharset(charset).setAutoDetectCharset(autoDetectCharset);
            HttpConnectionBuilder hb = HttpConnectionBuilder.create().setConfig(config);
            if (proxy != null) hb.setProxy(proxy);
            HttpConnection hc = hb.build();
            HttpReq req = new HttpReq(HttpMethod.POST, url);
            if (paras!=null) req.setParas(paras);
            if (header!=null) req.setHeader(header);
            if (data!=null) req.setData(data);
            return hc.exec(req);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static HttpEntity get(String url, Map<String, String> paras, Map<String, String> header,
                                 ProxyEntity proxy, Charset charset, Integer connectTimeout,
                                 Integer readTimeout) {
        return HttpKit.get(url, paras, header, proxy, charset, connectTimeout, readTimeout, false);
    }

    public static HttpEntity get(String url, Map<String, String> paras, Map<String, String> header,
                                 ProxyEntity proxy, Charset charset) {
        return HttpKit.get(url, paras, header, proxy, charset, HttpConst.DEF_TIMEOUT, HttpConst.DEF_SOTIMEOUT);
    }

    public static HttpEntity get(String url, Map<String, String> paras, Map<String, String> header, Charset charset) {
        return HttpKit.get(url, paras, header, null, charset);
    }

    public static HttpEntity get(String url, Map<String, String> paras, Map<String, String> header, Boolean autoDetectCharset) {
        return HttpKit.get(url, paras, header, null, null, HttpConst.DEF_TIMEOUT, HttpConst.DEF_SOTIMEOUT, autoDetectCharset);
    }

    public static HttpEntity get(String url, Map<String, String> paras, Charset charset) {
        return HttpKit.get(url, paras, null, charset);
    }

    public static HttpEntity get(String url, Map<String, String> para, Boolean autoDetectCharset) {
        return HttpKit.get(url, para, null, autoDetectCharset);
    }

    public static HttpEntity get(String url, Charset charset) {
        return HttpKit.get(url, null, charset);
    }

    public static HttpEntity get(String url, Boolean autoDetectCharset) {
        return HttpKit.get(url, null, autoDetectCharset);
    }

    public static HttpEntity get(String url) {
        return HttpKit.get(url, HttpConst.DEF_CONTENT_CHARSET);
    }

    public static HttpEntity post(String url, Map<String, String> paras, String data, Map<String, String> header,
                                  ProxyEntity proxy, Charset charset, Boolean autoComplete) {
        return HttpKit.post(url, paras, data, header, proxy, charset, HttpConst.DEF_TIMEOUT, HttpConst.DEF_SOTIMEOUT, autoComplete);
    }

    public static HttpEntity post(String url, Map<String, String> paras, String data, Map<String, String> header, Charset charset) {
        return HttpKit.post(url, paras, data, header, null, charset, false);
    }

    public static HttpEntity post(String url, Map<String, String> paras, String data, Charset charset, Boolean autoDetectCharset) {
        return HttpKit.post(url, paras, data, null, null, charset, autoDetectCharset);
    }

    public static HttpEntity post(String url, Map<String, String> paras, String data, Charset charset) {
        return HttpKit.post(url, paras, data, null, charset);
    }

    public static HttpEntity post(String url, String data, ProxyEntity pe, Charset charset) {
        return HttpKit.post(url, null, data, null, pe, charset, false);
    }


    public static HttpEntity post(String url, String data, Charset charset) {
        return HttpKit.post(url, data, null, charset);
    }

    public static HttpEntity post(String url, String data) {
        return HttpKit.post(url, data, null);
    }

}
