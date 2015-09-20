		<div id="sidebar">
			<div id="search" class="sidebar_entry">
				<div class="sidebar_header">Search</div>
				<input  id="s" type="text" value="search..." onfocus="if (this.value=='search...') this.value='';" onfocusout="if (this.value=='') this.value='search...';">
			</div>
			<div id="categories"  class="sidebar_entry">
				<div class="sidebar_header">Categories</div>
				<div id="category_list">
	  <ul>
  <% CategoryDAO categoryDAO = new CategoryDAO();
      List<Category> categoryList = categoryDAO.getAllCategories();
      for (Category category : categoryList) { %>
      <li><a class="label" href="categoryId=<%=category.getId()%>">
              <%=category.getName()%></a>
      </li>
      <%}%>
  </ul>
</div>
			</div>
		</div>
