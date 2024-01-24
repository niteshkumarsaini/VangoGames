const service_container = document.getElementById("service-container");

const selectedGames = [
    {
        "id": 1,
        "game_name": "Christmas Match 3",
        "category": "matching",
        "min_age": 1,
        "max_age": 5,
        "image_path": "Game_Cover/1.png",
        "url":"/games/game1/index.html"

    },
    {
        "id": 2,
        "game_name": "Christmas Ballons",
        "category": "arcade",
        "min_age": 5,
        "max_age": 10,
        "image_path": "Game_Cover/2.png",
        "url":"/games/game2/index.html"

    },
    {
        "id": 3,
        "game_name": "Great Air Battles",
        "category": "action",
        "min_age": 5,
        "max_age": 20,
        "image_path": "Game_Cover/3.png",
        "url":"/games/game3/index.html"

    },
    {
        "id": 4,
        "game_name": "Super Pongoal",
        "category": "Soccer",
        "min_age": 5,
        "max_age": 10,
        "image_path": "Game_Cover/4.png",
        "url":"/games/game4/index.html"

    },
    {
        "id": 5,
        "game_name": "MGFK",
        "category": "Maths",
        "min_age": 5,
        "max_age": 10,
        "image_path": "Game_Cover/5.png",
        "url":"/games/game5/index.html"

    }
    ,
    {
        "id": 6,
        "game_name": "Supercars Puzzle",
        "category": "Scenery Merging",
        "min_age": 5,
        "max_age": 20,
        "image_path": "Game_Cover/6.png",
        "url":"/games/game6/index.html"

    },
    {
        "id": 7,
        "game_name": "Forest Brothers",
        "category": "Run and Crossings",
        "min_age": 5,
        "max_age": 20,
        "image_path": "Game_Cover/7.png",
        "url":"/games/game7/index.html"

    },
    {
        "id": 8,
        "game_name": "Crazy Car",
        "category": "sports",
        "min_age": 5,
        "max_age": 20,
        "image_path": "Game_Cover/8.png",
        "url":"/games/game8/index.html"

    },
    {
        "id": 9,
        "game_name": "Kindom Defence",
        "category": "Defence",
        "min_age": 5,
        "max_age": 20,
        "image_path": "Game_Cover/9.png",
        "url":"/games/game9/index.html"

    }
    ,
    {
        "id": 10,
        "game_name": "Mad Fish",
        "category": "Eating Fish",
        "min_age": 5,
        "max_age": 20,
        "image_path": "Game_Cover/10.png",
        "url":"/games/game10/index.html"

    }
    ,
    {
        "id": 11,
        "game_name": "Sahara Invasion",
        "category": "Shooting",
        "min_age": 5,
        "max_age": 50,
        "image_path": "Game_Cover/11.png",
        "url":"/games/game11/index.html"

    }
    ,
    {
        "id": 12,
        "game_name": "Warriors Vs Evil Spirit",
        "category": "action",
        "min_age": 5,
        "max_age": 50,
        "image_path": "Game_Cover/12.png",
        "url":"/games/game12/index.html"

    },
    {
        "id": 13,
        "game_name": "Brick Breaker Unicorn",
        "category": "adventure",
        "min_age": 5,
        "max_age": 10,
        "image_path": "Game_Cover/13.png",
        "url":"/games/game13/index.html"

    }
    ,
    {
        "id": 14,
        "game_name": "Grand Commander",
        "category": "action",
        "min_age": 5,
        "max_age": 50,
        "image_path": "Game_Cover/14.png",
        "url":"/games/game14/index.html"

    }
    ,
    {
        "id": 15,
        "game_name": "JAGO",
        "category": "Stick",
        "min_age": 5,
        "max_age": 20,
        "image_path": "Game_Cover/15.png",
        "url":"/games/game15/index.html"

    }
    ,
    {
        "id": 16,
        "game_name": "Pool 8 Ball",
        "category": "strategy",
        "min_age": 5,
        "max_age": 50,
        "image_path": "Game_Cover/16.png",
        "url":"/games/game16/index.html"

    }
    ,
    {
        "id": 17,
        "game_name": "Handless Millionnaire",
        "category": "strategy",
        "min_age": 5,
        "max_age": 50,
        "image_path": "Game_Cover/17.png",
        "url":"/games/game17/index.html"

    },

    {
        "id": 18,
        "game_name": "Santa Run",
        "category": "action",
        "min_age": 5,
        "max_age": 20,
        "image_path": "Game_Cover/18.png",
        "url":"/games/game18/index.html"

    },
    {
        "id": 19,
        "game_name": "Stack Jump",
        "category": "Jump",
        "min_age": 5,
        "max_age": 20,
        "image_path": "Game_Cover/19.png",
        "url":"/games/game19/index.html"

    },
    {
        "id": 20,
        "game_name": "Happy Halloween",
        "category": "Matching",
        "min_age": 5,
        "max_age": 20,
        "image_path": "Game_Cover/20.png",
        "url":"/games/game20/index.html"

    },
    {
        "id": 21,
        "game_name": "Angry Cat Shot",
        "category": "adventure",
        "min_age": 5,
        "max_age": 20,
        "image_path": "Game_Cover/21.png",
        "url":"/games/game21/index.html"

    },
    {
        "id": 22,
        "game_name": "Fruit Slacher",
        "category": "arcade",
        "min_age": 5,
        "max_age": 20,
        "image_path": "Game_Cover/22.png",
        "url":"/games/game22/index.html"

    },
    {
        "id": 23,
        "game_name": "Stick Monkey",
        "category": "Stick Game",
        "min_age": 5,
        "max_age": 20,
        "image_path": "Game_Cover/23.png",
        "url":"/games/game23/index.html"

    }
    ,
    {
        "id": 24,
        "game_name": "Plumber",
        "category": "puzzle",
        "min_age": 5,
        "max_age": 50,
        "image_path": "Game_Cover/24.png",
        "url":"/games/game24/index.html"

    }
    ,
    {
        "id": 25,
        "game_name": "Viking Escape",
        "category": "action",
        "min_age": 5,
        "max_age": 50,
        "image_path": "Game_Cover/25.png",
        "url":"/games/game25/index.html"

    },
    {
        "id": 26,
        "game_name": "Duck Hunter",
        "category": "arcade",
        "min_age": 5,
        "max_age": 20,
        "image_path": "Game_Cover/26.png",
        "url":"/games/game26/index.html"

    },
    {
        "id": 27,
        "game_name": "Halloween Bubble",
        "category": "sports",
        "min_age": 5,
        "max_age": 20,
        "image_path": "Game_Cover/27.png",
        "url":"/games/game27/index.html"

    },
    {
        "id": 28,
        "game_name": "Ninja Run New",
        "category": "Run",
        "min_age": 5,
        "max_age": 20,
        "image_path": "Game_Cover/28.png",
        "url":"/games/game28/index.html"

    }
    , {
        "id": 29,
        "game_name": "Fruit Snake",
        "category": "strategy",
        "min_age": 5,
        "max_age": 20,
        "image_path": "Game_Cover/29.png",
        "url":"/games/game29/index.html"

    }
    , {
        "id": 30,
        "game_name": "Tank Defender",
        "category": "adventure",
        "min_age": 5,
        "max_age": 20,
        "image_path": "Game_Cover/30.png",
        "url":"/games/game30/index.html"

    },
    , {
        "id": 31,
        "game_name": "Fishing Frenzy",
        "category": "adventure",
        "min_age": 5,
        "max_age": 20,
        "image_path": "Game_Cover/31.png",
        "url":"/games/game31/index.html"

    }, {
        "id": 32,
        "game_name": "Crazy Runner",
        "category": "adventure",
        "min_age": 5,
        "max_age": 20,
        "image_path": "Game_Cover/32.png",
        "url":"/games/game32/index.html"

    }
    , {
        "id": 33,
        "game_name": "Traffic",
        "category": "Traffic",
        "min_age": 5,
        "max_age": 20,
        "image_path": "Game_Cover/33.png",
        "url":"/games/game33/index.html"

    }
    , {
        "id": 34,
        "game_name": "Girl Dress Up",
        "category": "Fashion",
        "min_age": 5,
        "max_age": 10,
        "image_path": "Game_Cover/34.png",
        "url":"/games/game34/index.html"

    }

]

const gamesData = [
    {
        "title": "Pool",
        "image": "images/pool.jpg",
        "content": "Some quick example text to build on the card title and make up the bulk of the card's content."
    }
    ,
    {
        "title": "Bowling",
        "image": "images/bowling.jpg",
        "content": "Some quick example text to build on the card title and make up the bulk of the card's content."
    },
    {
        "title": "Table Soccer",
        "image": "images/tablesoccer.jpg",
        "content": "Some quick example text to build on the card title and make up the bulk of the card's content."
    },
    {
        "title": "Match Monsters",
        "image": "images/monster-match.jpg",
        "content": "Some quick example text to build on the card title and make up the bulk of the card's content."
    },
    {
        "title": "Bingo",
        "image": "images/bingo.jpeg",
        "content": "Some quick example text to build on the card title and make up the bulk of the card's content."
    },
    {
        "title": "Ludo",
        "image": "images/ludo.png",
        "content": "Some quick example text to build on the card title and make up the bulk of the card's content."
    },
    {
        "title": "Chess",
        "image": "images/chess.png",
        "content": "Some quick example text to build on the card title and make up the bulk of the card's content."
    },
    {
        "title": "Basketball",
        "image": "images/basketball.jpg",
        "content": "Some quick example text to build on the card title and make up the bulk of the card's content."
    }
]

function startGame(path){
//    console.log("calling me")
   window.location.href=selectedGames[path-1].url
//    console.log(path)
}

selectedGames.map((d) => {
if(d.id===2 || d.id===3 ||d.id===8 || d.id===12 || d.id===13 || d.id===14 || d.id===16 || d.id===17 || d.id===18 || d.id===19 || d.id===21 || d.id===22 || d.id===24|| d.id===25|| d.id===26 || d.id===27 || d.id===29 || d.id===30 || d.id===31 || d.id===32){
        const game = `<div class="card mx-2 my-3 card-design" style="cursor:pointer" onclick="startGame(${d.id})">
    <img src=${d.image_path} class="card-img-top card-image" alt="..." >
    <div class="container text-center">
    <div class="card-heading">${d.game_name}</div>
    </div>
    <div class="card-body">
    </div>
  </div>`
    service_container.insertAdjacentHTML("beforeend", game)
}
})

$(document).ready(() => {

    $("#carouselExampleCaptions").click(() => {
        console.log("I am in")
    })

    $("#logout").click(() => {
        Swal.fire({
            title: "Logout",
            text: "You have been logged out successfully.",
            icon: "success"
        }).then(() => {
            window.location.href = "/logout"
        })

    });

})

function loadAction(category,clickedButton){
 // Reset all buttons to default color
 console.log(category)
 service_container.innerHTML="";
 if(category==="all"){
    selectedGames.map((d)=>{
        if(d.id===2 || d.id===3 ||d.id===8 || d.id===12 || d.id===13 || d.id===14 || d.id===16 || d.id===17 || d.id===18 || d.id===19 || d.id===21 || d.id===22 || d.id===24|| d.id===25|| d.id===26 || d.id===27 || d.id===29 || d.id===30 || d.id===31 || d.id===32){
            const game = `<div class="card mx-2 my-3 card-design" style="cursor:pointer" onclick="startGame(${d.id})">
    <img src=${d.image_path} class="card-img-top card-image" alt="..." >
    <div class="container text-center">
    <div class="card-heading">${d.game_name}</div>
    </div>
    <div class="card-body">
    </div>
  </div>`
    service_container.insertAdjacentHTML("beforeend", game)
    }

    })
 }

 else if(category=="action"){
    service_container.innerHTML="";

selectedGames.map((d)=>{
    if(d.category==="action"){
        const game = `<div class="card mx-2 my-3 card-design" style="cursor:pointer" onclick="startGame(${d.id})">
    <img src=${d.image_path} class="card-img-top card-image" alt="..." >
    <div class="container text-center">
    <div class="card-heading">${d.game_name}</div>
    </div>
    <div class="card-body">
    </div>
  </div>`
    service_container.insertAdjacentHTML("beforeend", game)

    }
})

 }

 else if(category=="arcade"){
    service_container.innerHTML="";

selectedGames.map((d)=>{
    if(d.category==="arcade"){
        const game = `<div class="card mx-2 my-3 card-design" style="cursor:pointer" onclick="startGame(${d.id})">
    <img src=${d.image_path} class="card-img-top card-image" alt="..." >
    <div class="container text-center">
    <div class="card-heading">${d.game_name}</div>
    </div>
    <div class="card-body">
    </div>
  </div>`
    service_container.insertAdjacentHTML("beforeend", game)

    }
})

 }

 else if(category=="adventure"){
    service_container.innerHTML="";

selectedGames.map((d)=>{
    if(d.category==="adventure"){
        const game = `<div class="card mx-2 my-3 card-design" style="cursor:pointer" onclick="startGame(${d.id})">
    <img src=${d.image_path} class="card-img-top card-image" alt="..." >
    <div class="container text-center">
    <div class="card-heading">${d.game_name}</div>
    </div>
    <div class="card-body">
    </div>
  </div>`
    service_container.insertAdjacentHTML("beforeend", game)

    }
})

 }
 else if(category=="puzzle"){
    service_container.innerHTML="";

selectedGames.map((d)=>{
    if(d.category==="puzzle"){
        const game = `<div class="card mx-2 my-3 card-design" style="cursor:pointer" onclick="startGame(${d.id})">
    <img src=${d.image_path} class="card-img-top card-image" alt="..." >
    <div class="container text-center">
    <div class="card-heading">${d.game_name}</div>
    </div>
    <div class="card-body">
    </div>
  </div>`
    service_container.insertAdjacentHTML("beforeend", game)

    }
})

 }

 else if(category=="sports"){
    service_container.innerHTML="";

selectedGames.map((d)=>{
    if(d.category==="sports"){
        const game = `<div class="card mx-2 my-3 card-design" style="cursor:pointer" onclick="startGame(${d.id})">
        <img src=${d.image_path} class="card-img-top card-image" alt="..." >
        <div class="container text-center">
        <div class="card-heading">${d.game_name}</div>
        </div>
        <div class="card-body">
        </div>
      </div>`
        service_container.insertAdjacentHTML("beforeend", game)

    }
})

 }


 else if(category=="strategy"){
    service_container.innerHTML="";

selectedGames.map((d)=>{
    if(d.category==="strategy"){
        const game = `<div class="card mx-2 my-3 card-design" style="cursor:pointer" onclick="startGame(${d.id})">
    <img src=${d.image_path} class="card-img-top card-image" alt="..." >
    <div class="container text-center">
    <div class="card-heading">${d.game_name}</div>
    </div>
    <div class="card-body">
    </div>
  </div>`
    service_container.insertAdjacentHTML("beforeend", game)

    }
})

 }

 var buttons = document.querySelectorAll('.default-button');
 buttons.forEach(function(button) {
//    button.style.backgroundColor = '#007bff';
   button.style.color = 'blue';
 });

 // Change the color of the clicked button
//  clickedButton.style.backgroundColor = '#ff0000';  // Change to your desired color
 clickedButton.style.color = 'red';
}


$(document).on("pagecreate","#service-container",function(){
    $("#service-container").on("swipeleft",function(){
      alert("You swiped left!");
    });                       
  });

  var swiper = new Swiper('.swiper-container', {
    pagination: '.swiper-pagination',
    slidesPerView: 'auto',
    paginationClickable: true,
    spaceBetween: 0
});
document.addEventListener('DOMContentLoaded', function () {
    var mySwiper = new Swiper('.mySwiper', {
      // Add swiper options here
    });

    // Your custom content for each slide
    var slideContent = {
      slide1: 'Your custom content for Slide 1',
      slide2: 'Your custom content for Slide 2',
      slide3: 'Your custom content for Slide 3',
      // Add more content as needed
    };

    mySwiper.on('slideChange', function () {
      var activeIndex = mySwiper.activeIndex + 1;
      var slideId = 'slide' + activeIndex;
      document.getElementById(slideId).innerHTML = slideContent[slideId];
    });
  });

  
  