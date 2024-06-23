package my.net;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HttpCookie implements Cloneable {
    private String name;
    private String value;
    private String comment;
    private String commentURL;
    private boolean discard;
    private String portlist;
    private String domain;
    private long maxAge;
    private String path;
    private boolean secure;
    private int version;

    public HttpCookie(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public boolean hasExpired() {
        return maxAge <= 0;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setCommentURL(String url) {
        this.commentURL = url;
    }

    public String getCommentURL() {
        return commentURL;
    }

    public void setDiscard(boolean discard) {
        this.discard = discard;
    }

    public boolean getDiscard() {
        return discard;
    }

    public void setPortlist(String ports) {
        this.portlist = ports;
    }

    public String getPortlist() {
        return portlist;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getDomain() {
        return domain;
    }

    public void setMaxAge(long expiry) {
        this.maxAge = expiry;
    }

    public long getMaxAge() {
        return maxAge;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setSecure(boolean flag) {
        this.secure = flag;
    }

    public boolean getSecure() {
        return secure;
    }

    public String getName() {
        return name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int v) {
        this.version = v;
    }

    public static boolean domainMatches(String domain, String host) {
        if (domain == null || host == null) {
            return false;
        }
        return host.endsWith(domain);
    }

    public static List<HttpCookie> parse(String header) {
        List<HttpCookie> cookies = new ArrayList<>();
        String[] pairs = header.split(";\\s*");
        for (String pair : pairs) {
            String[] nameValue = pair.split("=", 2);
            if (nameValue.length == 2) {
                cookies.add(new HttpCookie(nameValue[0], nameValue[1]));
            }
        }
        return cookies;
    }

    @Override
    public String toString() {
        return name + "=" + value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HttpCookie that = (HttpCookie) obj;
        return discard == that.discard &&
               maxAge == that.maxAge &&
               secure == that.secure &&
               version == that.version &&
               Objects.equals(name, that.name) &&
               Objects.equals(value, that.value) &&
               Objects.equals(comment, that.comment) &&
               Objects.equals(commentURL, that.commentURL) &&
               Objects.equals(portlist, that.portlist) &&
               Objects.equals(domain, that.domain) &&
               Objects.equals(path, that.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value, comment, commentURL, discard, portlist, domain, maxAge, path, secure, version);
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Can't happen
        }
    }
}
