<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Venus Admin Dashboard</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admindash.css"/>
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&family=Playfair+Display:wght@600&display=swap" rel="stylesheet">
</head>
<body class="vs-bg">
  <div class="dashboard">
    <aside class="sidebar">
      <h2 class="logo">Admin</h2>
      <nav class="nav">
        <a href="#" class="nav-link">Dashboard</a>
        <a href="models.html" class="nav-link">Directory</a>
        <a href="#" class="nav-link">Booked Models</a>
        <a href="#" class="nav-link">Booking Inquiries</a>
        <a href="settings.html" class="nav-link">Settings</a>
        <a href="#" class="nav-link">Logout</a>
      </nav>
    </aside>

    <main class="main">
      <div class="top-center">
        <h1 class="venus-title">Venus</h1>
        <div class="search-container">
          <input type="text" placeholder="Search..." class="search-input">
          <span class="search-icon">
            <i class="fas fa-search"></i>
          </span>
        </div>
        
      </div>

      <div class="info-cards">
        <div class="card">Total Portfolio<br><strong>40</strong></div>
        <div class="card">Selected Portfolio<br><strong>12</strong></div>
        <div class="card">Messages<br><strong>3</strong></div>
      </div>

      <div class="model-table">
        <table>
          <thead>
            <tr>
              <th>Models</th>
              <th>Age</th>
              <th>Contact</th>
              <th>Status</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>Kaia Gerber<br><small>Fashion Model</small></td>
              <td>23</td>
              <td>kaia@gmail.com</td>
            
              <td>Available</td>
            </tr>
            <tr>
              <td>Bella Hadid<br><small>Fashion Model</small></td>
              <td>24</td>
              <td>bella11@gmail.com</td>
              <td>Booked</td>
            </tr>
            <tr>
              <td>Alex Consani<br><small>Fashion Model</small></td>
              <td>25</td>
              <td>alex24@gmail.com</td>
              
              <td>Booked</td>
            </tr>
            <tr>
              <td>Liu Wen<br><small>Fashion Model</small></td>
              <td>28</td>
              <td>liuwen@gmail.com</td>
              <td>Available</td>
            </tr>
          </tbody>
        </table>
      </div>
    </main>
  </div>
</body>