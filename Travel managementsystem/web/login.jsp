&lt;%@ page language=&quot;java&quot; contentType=&quot;text/html; charset=UTF-8&quot; pageEncoding=&quot;UTF-
8&quot;%&gt;
&lt;!DOCTYPE html&gt;
&lt;html&gt;
&lt;head&gt;
&lt;title&gt;Travel Management - Login&lt;/title&gt;
&lt;link rel=&quot;stylesheet&quot; href=&quot;css/style.css&quot;&gt;
&lt;/head&gt;
&lt;body&gt;
&lt;div class=&quot;login-container&quot;&gt;
&lt;h2&gt;Travel Management System&lt;/h2&gt;
&lt;h3&gt;Login&lt;/h3&gt;
&lt;% String message = (String) request.getAttribute(&quot;message&quot;);
if (message != null) { %&gt;
&lt;p class=&quot;error&quot;&gt;${message}&lt;/p&gt;
&lt;% } %&gt;

&lt;form action=&quot;LoginServlet&quot; method=&quot;post&quot;&gt;
&lt;input type=&quot;text&quot; name=&quot;username&quot; placeholder=&quot;Username&quot; required&gt;
&lt;input type=&quot;password&quot; name=&quot;password&quot; placeholder=&quot;Password&quot; required&gt;
&lt;button type=&quot;submit&quot;&gt;Login&lt;/button&gt;
&lt;/form&gt;
&lt;p&gt;&lt;a href=&quot;register.jsp&quot;&gt;Register here&lt;/a&gt;&lt;/p&gt;
&lt;/div&gt;
&lt;/body&gt;
&lt;/html&gt;