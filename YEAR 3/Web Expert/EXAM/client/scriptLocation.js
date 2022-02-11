window.addEventListener('load', (event) => {
    document.getElementById("locationTitle").innerText = sessionStorage.getItem("locationName");
});