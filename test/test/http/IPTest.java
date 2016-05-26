package test.http;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * 获取客户端真实IP 包括代理后的上一级IP
 * 
 * @author aliang
 * @version 1.0
 * @created 2014-3-30 上午9:34:17
 */
public class IPTest {

	/**
	 * 经过代理以后，由于在客户端和服务之间增加了中间层，因此服务器无法直接拿到客户端的IP, 转发请求的HTTP头信息中，增加了
	 * X－FORWARDED－FOR 信息用以跟踪原有的客户端IP地址和原来客户端请求的服务器地址。
	 * 
	 * @param request
	 * @return
	 */

	public String getIpAddr(HttpServletRequest request) {

		String ip = request.getHeader("x-forwarded-for");

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}

		return ip;
	}

}
