window.onload = function () {
    onceLoaded();


};
function onceLoaded() {
    fetch('https://reqres.in/api/register', {
        method: 'POST',
        body: JSON.stringify({
            
            email: "eve.holt@reqres.in",
            password: "pistol"
           
        }),
        headers: {
            'Content-type': 'application/json; charset=UTF-8'
        }
        
    })
        .then((response) => response.json())
        .then((json) => {
            console.log(json);
        })
        .catch((err) => console.error("error:", err));
}