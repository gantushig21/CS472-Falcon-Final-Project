<%--
  Created by IntelliJ IDEA.
  User: gantushig
  Date: 5/10/20
  Time: 1:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../fragments/header.jsp">
    <c:param name="title" value="Home Page" />
</c:import>

<div class="container mtb" style="padding-top: 50px;">
    <div class="row">
        <div class="col-lg-6">
            <img class="img-responsive" src="img/agency.jpg" alt="">
        </div>

        <div class="col-lg-6">
            <h4>More About Our system.</h4>
            <p>We using that system for helps people to find their job depending on their profession and location.
                When user fills out the search form it will show him all open job positions which might interest him or her, and if it is, they can contact with employer and apply for a job.
                Of course for recruiters, they can add job post to hire new member who is needed in their company. </p>
            <h4>Technologies</h4>
            <p>- Ajax, Json, Jquery <br/>
                - MVC architecture <br/>
                - Servlet/JSP/JSTL <br/>
            </p>
            <h4>Configuration and Installation</h4>
            <p>- IDE: Intellij IDEA ultimate 2020.1 <br/>
                - Apache Tomcat: 9.0.311 <br/>
                - Bootstrap solid template <br/>
            </p>
            <h4>Team Source Code in Github</h4>
            <p> <a href="https://github.com/gantushig21/CS472-Falcon-Final-Project">Git project link</a>
            </p>
<%--            <p><br/><a href="contact.html" class="btn btn-theme">Contact Us</a></p>--%>
        </div>
    </div>
</div>

<!-- *****************************************************************************************************************
TEEAM MEMBERS
***************************************************************************************************************** -->

<div class="container mtb">
    <div class="row centered">
        <h3 class="mb">MEET OUR TEAM</h3>

        <div class="col-lg-4 col-md-4 col-sm-4">
            <div class="he-wrap tpl6">
                <img src="img/team/Gantushig.jpg" alt="">
                <div class="he-view">
                    <div class="bg a0" data-animate="fadeIn">
                        <h3 class="a1" data-animate="fadeInDown">Contact Me:</h3>
                        <a href="#" class="dmbutton a2" data-animate="fadeInUp"><i class="fa fa-envelope"></i></a>
                        <a href="#" class="dmbutton a2" data-animate="fadeInUp"><i class="fa fa-twitter"></i></a>
                    </div>
                    <!-- he bg -->
                </div>
                <!-- he view -->
            </div>
            <!-- he wrap -->
            <h4>Gantushig Bayasgalan</h4>
            <h5 class="ctitle">CODE SMASHER</h5>
            <p>Young heart believe me he can do write code. Everything is possible to him.</p>
            <div class="hline"></div>
        </div>

        <div class="col-lg-4 col-md-4 col-sm-4">
            <div class="he-wrap tpl6">
                <img src="img/team/Ankhtuya.jpg" alt="">
                <div class="he-view">
                    <div class="bg a0" data-animate="fadeIn">
                        <h3 class="a1" data-animate="fadeInDown">Contact Me:</h3>
                        <a href="#" class="dmbutton a2" data-animate="fadeInUp"><i class="fa fa-envelope"></i></a>
                        <a href="#" class="dmbutton a2" data-animate="fadeInUp"><i class="fa fa-twitter"></i></a>
                    </div>
                    <!-- he bg -->
                </div>
                <!-- he view -->
            </div>
            <!-- he wrap -->
            <h4>Ankhtuya Ochirbat</h4>
            <h5 class="ctitle">LEAD DEVELOPER</h5>
            <p>Well balanced, excellent leader. The prettiest member of team.</p>
            <div class="hline"></div>
        </div>

        <div class="col-lg-4 col-md-4 col-sm-4">
            <div class="he-wrap tpl6">
                <img src="img/team/Tamir.jpg" alt="">
                <div class="he-view">
                    <div class="bg a0" data-animate="fadeIn">
                        <h3 class="a1" data-animate="fadeInDown">Contact Me:</h3>
                        <a href="#" class="dmbutton a2" data-animate="fadeInUp"><i class="fa fa-envelope"></i></a>
                        <a href="#" class="dmbutton a2" data-animate="fadeInUp"><i class="fa fa-twitter"></i></a>
                    </div>
                    <!-- he bg -->
                </div>
                <!-- he view -->
            </div>
            <!-- he wrap -->
            <h4>Tamir Batbayar</h4>
            <h5 class="ctitle">SMILEY</h5>
            <p>Good supporter and really good at for smile.</p>
            <div class="hline"></div>
        </div>

    </div>
</div>

<!-- *****************************************************************************************************************
TESTIMONIALS
***************************************************************************************************************** -->
<div id="twrap">
    <div class="container centered">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2">
                <i class="fa fa-comment-o"></i>
                <p>Falcons are birds of prey and are therefore known for their incredible hunting skills and being a ruthless, dominant predator within their environment. Falcons hunt their prey from the skies above and swoop down through the air to catch it once they have spotted a meal with their incredible eyesight..</p>
                <h4><br/>We pet FALCON</h4>
                <p>MONGOLIA</p>
            </div>
        </div>
    </div>
</div>

<c:import url="../fragments/footer.jsp" />
