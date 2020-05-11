<%--
  Created by IntelliJ IDEA.
  User: gantushig
  Date: 5/10/20
  Time: 4:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form class="contact-form php-mail-form" role="form" method="POST" autocomplete="off" id="add-job-form">
    <h4>Job Information</h4>
    <div class="hline" style="margin-bottom: 20px;"></div>
    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <input type="name" name="company-name" class="form-control" id="company-name" placeholder="Company Name" data-rule="minlen:1" data-msg="Required" value="Infinite Solutions">
                <div class="validate"></div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-group">
                <input type="text" name="title" class="form-control" id="job-title" placeholder="Job Title" data-rule="minlen:1" data-msg="Required" value="Software Engineer">
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6">
            <div class="form-group autocomplete">
                <input value="california" type="text" name="state" class="form-control" id="add-job-state" placeholder="State" data-rule="minlen:1" data-msg="Required" autocomplete="false">
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-group autocomplete">
                <input value="Alameda" type="text" name="city" class="form-control" id="add-job-city" placeholder="City" data-rule="minlen:1" data-msg="Required" autocomplete="false">
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <input type="text" name="skills" class="form-control" id="skills" placeholder="Skills" data-rule="minlen:1" data-msg="Required" value="C++ Java">
            </div>
        </div>
        <div class="col-md-6">
            <div class="job-form-check">
                <div class="job-radio-btn">
                    <div class="radio">
                        <label><input type="radio" name="job-status" checked>Full Time</label>
                    </div>
                </div>
                <div class="job-radio-btn">
                    <div class="radio">
                        <label><input type="radio" name="job-status">Part Time</label>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="form-group">
        <textarea class="form-control" name="job-description" id="job-description" placeholder="Job Description" rows="5">
            Hello World
        </textarea>
        <div class="validate"></div>
    </div>

    <h4 style="margin-top: 20px;">Contact Information</h4>
    <div class="hline" style="margin-bottom: 20px;"></div>

    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <input type="text" name="recruiter-name" class="form-control" id="recruiter-name" placeholder="Name" data-rule="minlen:1" data-msg="Required" autocomplete="false" value="Gantushig Bayasgalan">
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-group">
                <input type="text" name="recruiter-phone" class="form-control" id="recruiter-phone" placeholder="Phone Number" data-rule="minlen:1" data-msg="Required" value="+976 95374005">
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="form-group">
                <input type="text" name="recruiter-email" class="form-control" id="recruiter-email" placeholder="Email" data-rule="minlen:1" data-msg="Required" value="gantushig21@gmail.com">
            </div>
        </div>
    </div>

    <div class="loading" id="add-job-loading"></div>
    <div class="error-message"></div>
    <div class="sent-message">Your job post has been added successful. Thank you!</div>

    <div class="form-send">
        <button type="submit" class="btn btn-large">Post a Job</button>
    </div>
</form>

<div id="myModal" class="job-modal">
    <div class="job-modal-content">
        <div class="job-modal-body">
            <p id="messageModal"></p>
        </div>
        <div class="job-modal-footer">
            <button id="booksListModal" class="btn btn-theme">Go Books List</button>
            <button id="okayModal" class="btn btn-theme">Okay</button>
        </div>
    </div>
</div>

<script defer src="js/job-form.js"></script>

