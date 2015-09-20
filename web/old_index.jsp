<%@ page import="com.cam.shop.entity.Category" %>
<%@ page import="com.cam.shop.dao.CategoryDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.cam.shop.dao.CityDAO" %>
<%@ page import="com.cam.shop.entity.City" %>
<%@ page import="com.cam.shop.dao.UserDAO" %>
<%@ page import="com.cam.shop.entity.User" %>
<%--
  Created by IntelliJ IDEA.
  User: cam
  Date: 12.07.15
  Time: 23:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Categories</title>
  </head>
  <body>
  <p>Categories</p>
  <ul>
  <% CategoryDAO categoryDAO = new CategoryDAO();
      List<Category> categoryList = categoryDAO.getAllCategories();
      for (Category category : categoryList) { %>
      <li><a class="label" href="categoryId=<%=category.getId()%>">
              <%=category.getName()%></a>
      </li>
      <%}%>
  </ul>
  <p>Cities</p>
  <ul>
      <% CityDAO cityDAO = new CityDAO();
          List<City> cityList = cityDAO.getAllCities();
          for (City city : cityList) { %>
      <li><a class="label" href="cityId=<%=city.getId()%>">
          <%=city.getName()%></a>
      </li>
      <%}%>
  </ul>
  <p>Users</p>
  <ul>
      <% UserDAO userDAO = new UserDAO();
          List<User> userList = userDAO.getAllUsers();
          for (User user : userList) { %>
      <li><a class="label" href="userId=<%=user.getId()%>">
          <%=user.getFirstName() + user.getLastName()%></a>
      </li>
      <%}%>
  </ul>
    </body>
</html>