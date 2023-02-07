<%--
  Created by IntelliJ IDEA.
  User: caco
  Date: 2023/02/02
  Time: 5:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

  <title>Hello, world!</title>
</head>
<body>
<div class="container-fluid">
  <div class="row">
    <!--    <h1>Header</h1>-->
    <div class="row">
      <div class="col">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
          <div class="container-fluid">
            <a class="navbar-brand" href="#">Navbar</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
              <div class="navbar-nav">
                <a class="nav-link active" aria-current="page" href="#">Home</a>
                <a class="nav-link" href="#">Features</a>
                <a class="nav-link" href="#">Pricing</a>
                <a class="nav-link disabled">Disabled</a>
              </div>
            </div>
          </div>
        </nav>
      </div>
    </div>
    <!--    header end-->
    <!--    기존의 <h1>Header</h1>끝>-->
    <div class="row content">
      <div class="col">
        <div class="card">
          <div class="card-header">
            Featured
          </div>
          <div class="card-body">
            <h5 class="card-title">Special title treatment</h5>
            <table class="table">
              <thead>
              <tr>
                <th scope="col">Tno</th>
                <th scope="col">Title</th>
                <th scope="col">Writer</th>
                <th scope="col">DueDate</th>
                <th scope="col">Finished</th>
              </tr>
              </thead>
              <tbody>
              <c:forEach items="${responseDTO.dtoList}" var="dto">
                <tr>
                  <th scope="row"><c:out value="${dto.tno}"/></th>
                  <td><a href="/todo/read?tno=${dto.tno}" class="text-decoration-none"><c:out value="${dto.title}"/></a></td>
                  <td><c:out value="${dto.writer}"/></td>
                  <td><c:out value="${dto.dueDate}"/></td>
                  <td><c:out value="${dto.finished}"/></td>
                </tr>
              </c:forEach>
              </tbody>
            </table>
            <div class="float-end">
              <ul class="pagination flex-wrap">
                <c:if test="${responseDTO.prev}">
                  <li class="page-item">
                    <a class="page-link" data-num="${responseDTO.start - 1}">Previous</a>
                  </li>
                </c:if>
                <c:forEach begin="${responseDTO.start}" end="${responseDTO.end}" var="num">
                  <li class="page-item ${responseDTO.page == num? "active":""} "><a class="page-link" data-num="${num}">${num}</a> </li>
                </c:forEach>
                <c:if test="${responseDTO.next}">
                  <li class="page-item">
                    <a class="page-link" data-num="${responseDTO.end + 1}">Next</a>
                  </li>
                </c:if>
              </ul>
            </div>
            <script>
              document.querySelector(".pagination").addEventListener("click", function(e){
                e.preventDefault();
                e.stopPropagation();

                const target = e.target;

                if (target.tagName !== 'A') {
                  return
                }
                const num = target.getAttribute("data-num");

                // 백틱으로 템플릿 처리, jsp el이 아니라는걸 \${}로 표시
                self.location = `/todo/list?page=\${num}`
              })
            </script>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="row content">

  </div>
  <div class="row footer">
    <!--    <h1>Footer</h1>-->
    <div class="row fixed-bottom" style="z-index: -100">
      <footer class="py-1 my-1">
        <p class="text-center text-muted">Footer</p>
      </footer>
    </div>
  </div>
</div>
<!-- Optional JavaScript; choose one of the two! -->

<!-- Option 1: Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<!-- Option 2: Separate Popper and Bootstrap JS -->
<!--
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
-->
</body>
</html>
