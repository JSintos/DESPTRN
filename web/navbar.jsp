<nav class="navbar navbar-expand-lg navbar-light bg-green">
    <div class="container">
        <a class="navbar-brand" href="/">
            <img alt="Navbar brand" height="75" width="75" src="assets/images/navbar-brand.png">
        </a>
        <button aria-controls="mainNavbar" aria-expanded="false" aria-label="Toggle navigation" class="navbar-toggler" data-target="#mainNavbar" data-toggle="collapse" type="button">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="mainNavbar">
            <ul class="navbar-nav mr-auto">
                <% 
                
                	if(request.getParameter("activeClass") != null && request.getParameter("activeClass").equals("Home")) {
                %>
                <li class="nav-item active">
                <%
                
                	}
                	else {
                		
                %>
                <li class="nav-item">
                <%
                	}
                
                %>
                    <a class="nav-link" href="/">Home</a>
                </li>

                <% 
                
                	if(request.getParameter("activeClass") != null && request.getParameter("activeClass").equals("Products")) {		
                %>
                <li class="nav-item active">
                <%
                		
                	}
                	else {
                		
                %>
                <li class="nav-item">
                <%
                	}
                
                %>
                    <a class="nav-link" href="/products">Products</a>
                </li>

                <% 
                
                	if(request.getParameter("activeClass") != null && request.getParameter("activeClass").equals("Order")) {
                %>
                <li class="nav-item active">
                <%
                		
                	}
                	else {
                		
                %>
                <li class="nav-item">
                <%
                	}
                
                %>
                    <a class="nav-link" href="/choosemeal">Order</a>
                </li>
            </ul>
        </div>
    </div>
</nav>