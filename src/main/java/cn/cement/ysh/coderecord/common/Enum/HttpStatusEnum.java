package cn.cement.ysh.coderecord.common.Enum;


import org.springframework.lang.Nullable;

/**
 * @author YSH
 * @created 20190105
 * @desc 定义http 状态码枚举
 */
public enum HttpStatusEnum {
    RS_100(100, "Continue","继续"),
    RS_101(101, "Switching Protocols","切换协议"),
    RS_102(102, "Processing","处理"),
    RS_103(103, "CheckPoint","检查点"),

    RS_200(200, "Ok","请求成功"),
    RS_201(201, "Created","已创建"),
    RS_202(202, "Accepted","已接受"),
    RS_203(203, "Non-Authoritative Information","非授权信息"),
    RS_204(204, "No Content","无内容"),
    RS_205(205, "Reset Content","重置内容"),
    RS_206(206, "Partial Content","部分内容"),
    RS_207(207, "Multi-Status",""),
    RS_208(208, "Already Reported","已报告"),
    RS_226(226, "IM Used","IM Used"),

    RS_300(300, "Multiple Choices","多种选择"),
    RS_301(301, "Moved Permanently","永久移动"),
    RS_302(302, "Found","临时移动"),
    RS_303(303, "See Other","查看其它地址"),
    RS_304(304, "Not Modified","未修改"),
    /** @deprecated */
    @Deprecated
    RS_305(305, "Use Proxy","使用代理"),
    RS_306(306,"Unused","废弃"),
    RS_307(307, "Temporary Redirect","临时重定向"),
    RS_308(308, "Permanent Redirect","永久重定向"),
    RS_400(400, "Bad Request","客户端请求服务器无法理解"),
    RS_401(401, "Unauthorized","未授权"),
    RS_402(402, "Payment Required","保留"),
    RS_403(403, "Forbidden","拒绝执行"),
    RS_404(404, "Not Found","资源无法找到"),
    RS_405(405, "Method Not Allowed","请求中方法禁止"),
    RS_406(406, "Not Acceptable","无法完成请求"),
    RS_407(407, "Proxy Authentication Required","需要代理身份认证"),
    RS_408(408, "Request Timeout","请求时间超时"),
    RS_409(409, "Conflict","处理请求发生冲突"),
    RS_410(410, "Gone","资源永久删除"),
    RS_411(411, "Length Required","无法处理没有Content-Length的请求"),
    RS_412(412, "Precondition Failed","先决条件错误"),
    RS_413(413, "Payload Too Large","请求的载荷过大"),

    RS_414(414, "URI Too Long","URI过长"),

    RS_415(415, "Unsupported Media Type","无法处理的媒体格式"),
    RS_416(416, "Requested range not satisfiable","请求范围无效"),
    RS_417(417, "Expectation Failed","无法满足Expect的请求头信息"),
    RS_418(418, "I'm a teapot","不能冲泡咖啡,因为这是茶壶"),
    /** @deprecated */
    @Deprecated
    RS_419(419, "Insufficient Space On Resource","资源空间不足"),
    /** @deprecated */
    @Deprecated
    RS_420(420, "Method Failure","Method Failure"),
    /** @deprecated */
    @Deprecated
    RS_421(421, "Destination Locked","目标已锁定"),
    RS_422(422, "Unprocessable Entity","无法处理的实体"),
    RS_423(423, "Locked","已锁定"),
    RS_424(424, "Failed Dependency","失败的依赖项"),
    RS_426(426, "Upgrade Required","需要升级"),
    RS_428(428, "Precondition Required","要求先决条件"),
    RS_429(429, "Too Many Requests","请求太多"),
    RS_431(431, "Request Header Fields Too Large","请求头字段太大"),
    RS_451(451, "Unavailable For Legal Reasons","因法律原因不可用"),
    RS_500(500, "Internal Server Error","服务器内部错误"),
    RS_501(501, "Not Implemented","不支持的请求"),
    RS_502(502, "Bad Gateway","网关或者代理收到了一个无效的响应"),
    RS_503(503, "Service Unavailable","暂时的无法处理请求"),
    RS_504(504, "Gateway Timeout","网关或代理未及时收到信息"),
    RS_505(505, "HTTP Version not supported","不支持的HTTP协议版本"),
    RS_506(506, "Variant Also Negotiates","变体也可以协商"),
    RS_507(507, "Insufficient Storage","存储不足"),
    RS_508(508, "Loop Detected","回路检测"),
    RS_509(509, "Bandwidth Limit Exceeded","超出带宽限制"),
    RS_510(510, "Not Extended","未扩展"),
    RS_511(511, "Network Authentication Required","需要网络身份验证");

    public final int code;
    public final String englishExplain;
    public final String chineseExplain;


    HttpStatusEnum(int code, String englishExplain, String chineseExplain) {
        this.code = code;
        this.englishExplain = englishExplain;
        this.chineseExplain = chineseExplain;
    }
    public int getCode() {
        return code;
    }

    public String getChinesePhrase() {
        return chineseExplain;
    }
    public int value() {
        return this.code;
    }

    public String getEnglishExplain() {
        return this.englishExplain;
    }

    public HttpStatusEnum.Series series() {
        return HttpStatusEnum.Series.valueOf(this);
    }

    public boolean is1xxInformational() {
        return this.series() == HttpStatusEnum.Series.INFORMATIONAL;
    }

    public boolean is2xxSuccessful() {
        return this.series() == HttpStatusEnum.Series.SUCCESSFUL;
    }

    public boolean is3xxRedirection() {
        return this.series() ==HttpStatusEnum.Series.REDIRECTION;
    }

    public boolean is4xxClientError() {
        return this.series() == HttpStatusEnum.Series.CLIENT_ERROR;
    }

    public boolean is5xxServerError() {
        return this.series() == HttpStatusEnum.Series.SERVER_ERROR;
    }

    public boolean isError() {
        return this.is4xxClientError() || this.is5xxServerError();
    }

    public String toString() {
        return this.code + " " + this.name()+" "+this.englishExplain+" "+this.chineseExplain;
    }

    public static HttpStatusEnum valueOf(int statusCode) {
        HttpStatusEnum status = resolve(statusCode);
        if (status == null) {
            throw new IllegalArgumentException("No matching constant for [" + statusCode + "]");
        } else {
            return status;
        }
    }

    @Nullable
    public static HttpStatusEnum resolve(int statusCode) {
        HttpStatusEnum[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            HttpStatusEnum status = var1[var3];
            if (status.code == statusCode) {
                return status;
            }
        }

        return null;
    }

    public static enum Series {
        INFORMATIONAL(1),
        SUCCESSFUL(2),
        REDIRECTION(3),
        CLIENT_ERROR(4),
        SERVER_ERROR(5);

        private final int value;

        private Series(int value) {
            this.value = value;
        }

        public int value() {
            return this.value;
        }

        public static HttpStatusEnum.Series valueOf(HttpStatusEnum status) {
            return valueOf(status.code);
        }

        public static HttpStatusEnum.Series valueOf(int statusCode) {
            HttpStatusEnum.Series series = resolve(statusCode);
            if (series == null) {
                throw new IllegalArgumentException("No matching constant for [" + statusCode + "]");
            } else {
                return series;
            }
        }

        @Nullable
        public static HttpStatusEnum.Series resolve(int statusCode) {
            int seriesCode = statusCode / 100;
            HttpStatusEnum.Series[] series = Series.values();
            int length = series.length;

            for(int i = 0; i < length; ++i) {
                HttpStatusEnum.Series serie = series[i];
                if (serie.value == seriesCode) {
                    return serie;
                }
            }

            return null;
        }
    }
}

