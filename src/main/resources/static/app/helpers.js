urlBase = "app/";

function errorCheck(response, successCallback) {
    if (response.indexOf("Ok") >= 0) {
        successCallback();
    } else {
        alert(response);
    }
}