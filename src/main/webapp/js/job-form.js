function getCities(value) {
    $.ajax({
        type: "GET",
        url: "cities",
        data: {
            search: value
        },
        dataType: "json",
        success: function (data, textStatus, jqXHR) {
            if(data.success){
                autocomplete(document.getElementById("add-job-city"), data.cities);
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("Something really bad happened " + textStatus);
        }
    });
}

function autocomplete(inp, arr) {
    let currentFocus;
    inp.addEventListener("input", function(e) {
        let a, b, i, val = this.value;

        closeAllLists();

        if (!val)
            return false;
        currentFocus = -1;

        a = document.createElement("DIV");
        a.setAttribute("id", this.id + "autocomplete-list");
        a.setAttribute("class", "autocomplete-items");

        this.parentNode.appendChild(a);
        for (i = 0; i < arr.length; i++) {
            if (arr[i].substr(0, val.length).toUpperCase() == val.toUpperCase()) {
                b = document.createElement("DIV");
                b.innerHTML = "<strong>" + arr[i].substr(0, val.length) + "</strong>";
                b.innerHTML += arr[i].substr(val.length);
                b.innerHTML += "<input type='hidden' value='" + arr[i] + "'>";
                b.addEventListener("click", function(e) {
                    inp.value = this.getElementsByTagName("input")[0].value;
                    if (inp.id === "add-job-state") {
                        document.getElementById("add-job-city").value = "";
                        getCities(inp.value);
                    }
                    closeAllLists();
                });
                a.appendChild(b);
            }
        }
    });
    inp.addEventListener("keydown", function(e) {
        let x = document.getElementById(this.id + "autocomplete-list");
        if (x) x = x.getElementsByTagName("div");
        if (e.keyCode == 40) {
            currentFocus++;
            addActive(x);
        } else if (e.keyCode == 38) { //up
            currentFocus--;
            addActive(x);
        } else if (e.keyCode == 13) {
            e.preventDefault();
            if (currentFocus > -1) {
                if (x) x[currentFocus].click();
            }
        }
    });
    function addActive(x) {
        if (!x) return false;
        removeActive(x);
        if (currentFocus >= x.length) currentFocus = 0;
        if (currentFocus < 0) currentFocus = (x.length - 1);
        x[currentFocus].classList.add("autocomplete-active");
    }
    function removeActive(x) {
        for (let i = 0; i < x.length; i++) {
            x[i].classList.remove("autocomplete-active");
        }
    }
    function closeAllLists(elmnt) {
        let x = document.getElementsByClassName("autocomplete-items");
        for (let i = 0; i < x.length; i++) {
            if (elmnt != x[i] && elmnt != inp) {
                x[i].parentNode.removeChild(x[i]);
            }
        }
    }
    document.addEventListener("click", function (e) {
        closeAllLists(e.target);
    });
}


function addJob(e) {
    e.preventDefault();

    const data = {};
    $('#add-job-form').serializeArray().map(x => {data[x.name] = x.value;});

    const url = "jobs";

    console.log(data);
    $.ajax({
        url,
        type: 'POST',
        // contentType: "application/json; charset=utf-8",
        dataType: 'json',
        data: data,
        success: function(response){
            $('#addBook').trigger("reset");
            document.getElementById("add-job-loading").style.display = "none";
            showModal('Job post is added successful', 'success');
        },
        error: function(jqXHR) {
            let msg = "Something went wrong";
            if (jqXHR.status && jqXHR.status==400){
                msg = jqXHR.responseText;
            }
            showModal(msg, 'failed');
        }
    });
}
function showModal(msg, status) {
    const booksListBtn = document.getElementById("booksListModal");
    if (status == 'success') {
        booksListBtn.style.display = "inline-block";
    } else {
        booksListBtn.style.display = "none";
    }
    document.getElementById("messageModal").innerHTML = msg;
    const modal = document.getElementById("myModal");
    modal.style.display = "block";
}

function startModal() {
    const modal = document.getElementById("myModal");

    const booksListBtn = document.getElementById("booksListModal");
    const okayBtn = document.getElementById("okayModal");

    if (booksListBtn) {
        booksListBtn.onclick = function() {
            window.location.replace("jobs?action=search");
        }
    }
    if (okayBtn) {
        okayBtn.onclick = function() {
            modal.style.display = "none";
        }
    }

    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
}

$(function () {
    const states = ["alabama", "alaska", "arizona", "arkansas", "california", "colorado", "connecticut", "delaware", "florida", "georgia", "hawaii", "idaho", "illinois", "indiana", "iowa", "kansas", "kentucky", "louisiana", "maine", "maryland", "massachusetts", "michigan", "minnesota", "mississippi", "missouri", "montana", "nebraska", "nevada", "new hampshire", "new jersey", "new mexico", "new york", "north carolina", "north dakota", "ohio", "oklahoma", "oregon", "pennsylvania", "rhode island", "south carolina", "south dakota", "tennessee", "texas", "utah", "vermont", "virginia", "washington", "west virginia", "wisconsin", "wyoming"];

    autocomplete(document.getElementById("add-job-state"), states);

    $("#add-job-form").on('submit', addJob);
    startModal();
})

