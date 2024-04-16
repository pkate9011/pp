/**Q.10)Create a JSP page for an online multiple choice test. The questions are randomly
selected from a database and displayed on the screen. The choices are displayed using radio
buttons. When the user clicks on next, the next question is displayed. When the user clicks
on submit, display the total score on the screen


Exam.jsp*/


<%@page import="java.sql.*,java.util.*"%>
<%
// load a driver
Class.forName("org.postgresql.Driver");
// Establish Connection
conn = DriverManager.getConnection("jdbc:postgresql://192.168.1.21:5432/ty90", "ty90", "");
Set s = new TreeSet();
while(true){
int n = (int)(Math.random()*11+1);
s.add(n);
if(s.size()==5) break;
}
PreparedStatement ps = con.prepareStatement("select * from questions where qid=?");
%>
<form method='post' action='accept_ans.jsp'>
<table width='70%' align='center'>
<%
int i=0;
Vector v = new Vector(s);
session.setAttribute("qids",v);
int qid = Integer.parseInt(v.get(i).toString());
ps.setInt(1,qid);
ResultSet rs = ps.executeQuery();
rs.next();
%>
<tr>
<td><b>Question:<%=i+1%></b></td>
</tr>
<tr><td><pre><b><%=rs.getString(2)%></pre></b></td>
</tr>
<tr>
<td>
<b>
<input type='radio' name='op' value=1><%=rs.getString(3)%><br>
<input type='radio' name='op' value=2><%=rs.getString(4)%><br>
<input type='radio' name='op' value=3><%=rs.getString(5)%><br>
<input type='radio' name='op' value=4><%=rs.getString(6)%><br><br>
</b>
</td>
</tr>
<tr>
<td align='center'>
<input type='submit' value='Next' name='ok'>
<input type='submit' value='Submit' name='ok'>
</td>
</tr>
</table>
<input type='hidden' name='qno' value=<%=qid%>>
<input type='hidden' name='qid' value=<%=i+1%>>
</form>
</body>


acceptans.jsp:

	
	<%@page import="java.sql.*,java.util.*"%>
<%
Class.forName("org.postgresql.Driver");
Connection con = DriverManager.getConnection(
"jdbc:postgresql:ty1","postgres","");
Vector answers = (Vector)session.getAttribute("answers");
if(answers==null)
answers = new Vector();
int qno = Integer.parseInt(request.getParameter("qno"));
int ans = Integer.parseInt(request.getParameter("op"));
int i = Integer.parseInt(request.getParameter("qid"));
answers.add(qno+" "+ans);
session.setAttribute("answers",answers);String ok = request.getParameter("ok");
if(ok.equals("Submit") || i==5){
response.sendRedirect("result.jsp");
return;
}
PreparedStatement ps = con.prepareStatement("select * from questions where qid=?");
%>
<form method='post' action='accept_ans.jsp'>
<table width='70%' align='center'>
<%
Vector v = (Vector)session.getAttribute("qids");
int qid = Integer.parseInt(v.get(i).toString());
ps.setInt(1,qid);
ResultSet rs = ps.executeQuery();
rs.next();
%>
<tr>
<td><b>Question:<%=i+1%></b></td>
</tr>
<tr>
<td><pre><b><%=rs.getString(2)%></pre></b></td>
</tr>
<tr>
<td>
<b>
<input type='radio' name='op' value=1><%=rs.getString(3)%><br>
<input type='radio' name='op' value=2><%=rs.getString(4)%><br>
<input type='radio' name='op' value=3><%=rs.getString(5)%><br>
<input type='radio' name='op' value=4><%=rs.getString(6)%><br><br>
</b>
</td>
</tr>
<tr>
<td align='center'>
<input type='submit' value='Next' name='ok'>
<input type='submit' value='Submit' name='ok'>
</td>
</tr>
</table>
<input type='hidden' name='qno' value=<%=qid%>>
<input type='hidden' name='qid' value=<%=i+1%>>
</form></body>


result.jsp:

	<%@page import="java.sql.*,java.util.*,java.text.*"%>
<%
// load a driver
Class.forName("org.postgresql.Driver");
// Establish Connection
conn = DriverManager.getConnection("jdbc:postgresql://192.168.1.21:5432/ty90", "ty90",
""); Vector v = (Vector)session.getAttribute("answers");
if(v==null){
%>
<h1>No questions answered</h1>
<%
return;
}
PreparedStatement ps = con.prepareStatement("select ans from questions where qid=?");
int tot=0;
for(int i=0;i<v.size();i++){
String str = v.get(i).toString();
int j = str.indexOf(' ');
int qno = Integer.parseInt(str.substring(0,j));
int gans = Integer.parseInt(str.substring(j+1));
ps.setInt(1,qno);
ResultSet rs = ps.executeQuery();
rs.next();
int cans = rs.getInt(1);
if(gans==cans) tot++;
}
session.removeAttribute("qids");
session.removeAttribute("answers");
session.removeAttribute("qid");
%>
<h3>Score:<%=tot%></h1>
<center><a href='exam.jsp'>Restart</a></center>
</body>