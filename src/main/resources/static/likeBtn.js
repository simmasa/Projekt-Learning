
const urlC = 'http://localhost:8080/api';

window.addEventListener('load', function () {
  console.log("It's loaded!")
  var boxes = Array.from(document.getElementsByClassName("likebtn"))
   boxes.forEach(box => {
   box.addEventListener('click', function (e) {
   var likeDiv =e.currentTarget; //.dataset.corsoid)
   likeDiv.classList.toggle("text-white-50");
   likeDiv.classList.toggle("text-danger");
   postLike(e.currentTarget.dataset.corsoid);
   })
   })
//   var btnId = box.dataset.corsoId
//   box.addEventListener('click', function () {
//       console.log(btnId);
//   })})

})

//.addEventListener("click", function(){ alert("like"); });

//var idCorso = document.getElementsByClassName("likebtn");
//idCorso.addEventListener("click", function(){ alert("like"); });



//function(e) {
//    e.preventDefault();
//    let corsoId =     e.target.dataset.get('corso-id');
//axios.post('http://localhost:8080/like/' + corsoId)
//}
async function postLike(cId) {
    axios
        .get(urlC + '/' + cId + '/like')
        .then((response) => {
          console.log(response);
          return response.data;
        })
        .catch((error) => {
          console.log(error);
        });
}

async function axiosTest(cId) {
    const response = await axios.get(urlC + '/' + cId + '/like')
    return response.json()
}

function getCorsi () {
    axios.get('http://localhost:8080/api')
        .then(function (response) {
            response.data.forEach(element => {
                console.group(element.name)
                console.log(element.id);
                console.log(element.titolo);
                console.groupEnd();
                createCard(element);
            });
        })
        .catch(function (error) {
            console.log(error);
        })
    }
