<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8" />
    <title>Customer info</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin-style.css" />
    <script src="https://code.iconify.design/iconify-icon/1.0.7/iconify-icon.min.js"></script>
    <link
      href="https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css" rel="stylesheet"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  </head>
  <body>
    <div class="sidebar">
      <div class="logo-details">
        <i class="logo"> <img src="${pageContext.request.contextPath}/img/logoBlack.PNG" alt="logo" width="50px"></i>
        <span class="logo_name">DashCab</span>
      </div>
      <ul class="nav-links">
        <li>
          <a href="admin.jsp">
            <i class="bx bx-grid-alt"></i>
            <span class="links_name">Dashboard</span>
          </a>
        </li>
        <li>
          <a href="#" class="active">
            <i class="bx bx-list-ul"></i>
            <span class="links_name">Customers</span>
          </a>
        </li>
        <li>
          <a href="#">
            <i class="bx bx-box"></i>
            <span class="links_name">Bookings</span>
          </a>
        </li>
        <li>
          <a href="#">
            <i class="healthicons:truck-driver-outline"
              ><iconify-icon
                icon="healthicons:truck-driver-outline"
              ></iconify-icon
            ></i>
            <span class="links_name">Drivers</span>
          </a>
        </li>
        <li>
          <a href="#">
            <i class="bx bx-coin-stack"></i>
            <span class="links_name">Cars</span>
          </a>
        </li>
        <li>
          <a href="#">
            <i class="bx bx-book-alt"></i>
            <span class="links_name">User Reports</span>
          </a>
        </li>
        <li>
          <a href="#">
            <i class="bx bx-user"></i>
            <span class="links_name">Team</span>
          </a>
        </li>
        <li>
          <a href="#">
            <i class="bx bx-message"></i>
            <span class="links_name">Messages</span>
          </a>
        </li>
        <li>
          <a href="#">
            <i class="bx bx-heart"></i>
            <span class="links_name">Favrorites</span>
          </a>
        </li>
        <li>
          <a href="#">
            <i class="bx bx-cog"></i>
            <span class="links_name">Setting</span>
          </a>
        </li>
        <li class="log_out">
          <a href="index.jsp">
            <i class="bx bx-log-out"></i>
            <span class="links_name">Log out</span>
          </a>
        </li>
      </ul>
    </div>
    <section class="home-section">
      <nav>
        <div class="sidebar-button">
          <i class="bx bx-menu sidebarBtn"></i>
          <span class="dashboard">Dashboard</span>
        </div>
        <div class="search-box">
          <input type="text" placeholder="Search..." />
          <i class="bx bx-search"></i>
        </div>
        <div class="profile-details">
          <i class="bx bx-user"></i>
          <span class="admin_name">Ahzam Ahmed Asim</span>
          
        </div>
      </nav>

      <div class="container">
        <div class="inbox-container">
          <h1>Customer Details</h1>
          <table>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>NID</th>
              <th>Address</th>
              <th>Age</th>
              <th>Email</th>
              <th>Actions</th>
            </tr>
            <tr>
              <td>1</td>
              <td>John Doe</td>
              <td>A2525252</td>
              <td>Almaa</td>
              <td>30</td>
              <td>john@example.com</td>
              <td>
                <button class="button button-secondary">Edit</button>
                <button class="button">Delete</button>
              </td>
            </tr>
            <tr>
              <td>2</td>
              <td>Jane Smith</td>
              <td>A123456</td>
              <td>Muniyaage</td>
              <td>25</td>
              <td>jane@example.com</td>
              <td>
                <button class="button button-secondary">Edit</button>
                <button class="button">Delete</button>
              </td>
            </tr>
            <tr>
              <td>3</td>
              <td>Mohamed Absal</td>
              <td>A249660</td>
              <td>Vaarey Villa</td>
              <td>28</td>
              <td>Absal@example.com</td>
              <td>
                <button class="button button-secondary">Edit</button>
                <button class="button">Delete</button>
              </td>
            </tr>
            <tr>
              <td>3</td>
              <td>Mohamed Absal</td>
              <td>A249660</td>
              <td>Vaarey Villa</td>
              <td>28</td>
              <td>Absal@example.com</td>
              <td>
                <button class="button button-secondary">Edit</button>
                <button class="button">Delete</button>
              </td>
            </tr>
            <tr>
              <td>3</td>
              <td>Mohamed Absal</td>
              <td>A249660</td>
              <td>Vaarey Villa</td>
              <td>28</td>
              <td>Absal@example.com</td>
              <td>
                <button class="button button-secondary">Edit</button>
                <button class="button">Delete</button>
              </td>
            </tr>
            <tr>
              <td>3</td>
              <td>Mohamed Absal</td>
              <td>A249660</td>
              <td>Vaarey Villa</td>
              <td>28</td>
              <td>Absal@example.com</td>
              <td>
                <button class="button button-secondary">Edit</button>
                <button class="button">Delete</button>
              </td>
            </tr>
            <tr>
              <td>3</td>
              <td>Mohamed Absal</td>
              <td>A249660</td>
              <td>Vaarey Villa</td>
              <td>28</td>
              <td>Absal@example.com</td>
              <td>
                <button class="button button-secondary">Edit</button>
                <button class="button">Delete</button>
              </td>
            </tr>
            <tr>
              <td>3</td>
              <td>Mohamed Absal</td>
              <td>A249660</td>
              <td>Vaarey Villa</td>
              <td>28</td>
              <td>Absal@example.com</td>
              <td>
                <button class="button button-secondary">Edit</button>
                <button class="button">Delete</button>
              </td>
            </tr>
            <tr>
              <td>3</td>
              <td>Mohamed Absal</td>
              <td>A249660</td>
              <td>Vaarey Villa</td>
              <td>28</td>
              <td>Absal@example.com</td>
              <td>
                <button class="button button-secondary">Edit</button>
                <button class="button">Delete</button>
              </td>
            </tr>
            <!-- Add more rows for additional customers -->
          </table>
          <div class="button-container">
            <button class="button">Add New Customer</button>
          </div>
        </div>
      </div>
    </section>

    <script>
      let sidebar = document.querySelector(".sidebar");
      let sidebarBtn = document.querySelector(".sidebarBtn");
      sidebarBtn.onclick = function () {
        sidebar.classList.toggle("active");
        if (sidebar.classList.contains("active")) {
          sidebarBtn.classList.replace("bx-menu", "bx-menu-alt-right");
        } else sidebarBtn.classList.replace("bx-menu-alt-right", "bx-menu");
      };
    </script>
  </body>
</html>
