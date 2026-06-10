package com.travel.dao;
import com.travel.model.Package;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class PackageDAO {
public List&lt;Package&gt; getAllPackages() {
List&lt;Package&gt; packages = new ArrayList&lt;&gt;();
Connection conn = null;
try {
conn = DBConnection.getConnection();
String sql = &quot;SELECT * FROM packages&quot;;

PreparedStatement pstmt = conn.prepareStatement(sql);
ResultSet rs = pstmt.executeQuery();
while (rs.next()) {
Package pkg = new Package();
pkg.setPackageId(rs.getInt(&quot;package_id&quot;));
pkg.setPackageName(rs.getString(&quot;package_name&quot;));
pkg.setDestination(rs.getString(&quot;destination&quot;));
pkg.setDurationDays(rs.getInt(&quot;duration_days&quot;));
pkg.setDescription(rs.getString(&quot;description&quot;));
pkg.setPrice(rs.getBigDecimal(&quot;price&quot;));
pkg.setImageUrl(rs.getString(&quot;image_url&quot;));
packages.add(pkg);
}
} catch (SQLException e) {
e.printStackTrace();
}
DBConnection.closeConnection(conn);
return packages;
}
public Package getPackageById(int packageId) {
Connection conn = null;
Package pkg = null;
try {
conn = DBConnection.getConnection();
String sql = &quot;SELECT * FROM packages WHERE package_id = ?&quot;;
PreparedStatement pstmt = conn.prepareStatement(sql);
pstmt.setInt(1, packageId);
ResultSet rs = pstmt.executeQuery();
if (rs.next()) {
pkg = new Package();
pkg.setPackageId(rs.getInt(&quot;package_id&quot;));
pkg.setPackageName(rs.getString(&quot;package_name&quot;));
pkg.setDestination(rs.getString(&quot;destination&quot;));
pkg.setDurationDays(rs.getInt(&quot;duration_days&quot;));

pkg.setDescription(rs.getString(&quot;description&quot;));
pkg.setPrice(rs.getBigDecimal(&quot;price&quot;));
}
} catch (SQLException e) {
e.printStackTrace();
}
DBConnection.closeConnection(conn);
return pkg;
}
}
