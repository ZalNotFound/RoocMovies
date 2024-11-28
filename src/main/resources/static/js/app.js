var select = document.getElementById("style-select");

select.addEventListener("change", function() {
    if (select.value != null) {
        window.location = "http://localhost:9090/rocmovies/home/movie?style=" + select.value;
    }

});
