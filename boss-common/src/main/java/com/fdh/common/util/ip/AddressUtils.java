package com.fdh.common.util.ip;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fdh.common.util.StringUtil;
import com.fdh.common.util.http.RestTemplateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.Map;

/**
 * @description:  获取地址类
 * @date: 2019/6/6 10:41
 * @author: fdh
 */
public class AddressUtils {

    @Value("${boss.address-enabled}")
    private static boolean isAddressEnabled;

    private static final Logger LOGGER = LoggerFactory.getLogger(AddressUtils.class);

    /**
     * 淘宝ip查询接口
     */
    public static final String IP_URL = "http://ip.taobao.com/service/getIpInfo.php";

    public static String getRealAddressByIP(String ip) {
        String address = "XX XX";

        // 内网不查询
        if (IpUtils.internalIp(ip)) {
            return "内网IP";
        }
        if (isAddressEnabled) {
            ResponseEntity<String> result = RestTemplateUtils.post(IP_URL, "ip=" + ip, String.class);
            String rspStr = result.getBody();
            if (StringUtil.isEmpty(rspStr)) {
                LOGGER.error("获取地理位置异常 {}", ip);
                return address;
            }
            try {
                ObjectMapper mapper = new ObjectMapper();
                Map<String, String> map = mapper.readValue(rspStr, Map.class);
                if (map.containsKey("code") && "0".equals(map.get("code"))) {
                    String region = null;
                    String city = null;
                    if (map.containsKey("region")) {
                        region = map.get("region");
                    }
                    if (map.containsKey("city")) {
                        city = map.get("city");
                    }
                    address = region + " " + city;
                } else {
                    LOGGER.error("获取地理位置异常 {}", ip);
                    return address;
                }
            } catch (IOException e) {
                LOGGER.error("获取地理位置异常 {}", ip);
                return address;
            }
        }
        return address;
    }
}
