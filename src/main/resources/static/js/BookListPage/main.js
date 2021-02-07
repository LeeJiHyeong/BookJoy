// 페이지네이션 태그
const $paging=document.querySelector('#paging');
const state={
    'page':1
}

const FetchBook=()=>{
    const url=`http://localhost:8080/book/list?page=${state.page}`
    $.ajax(({
        url:url,
        type:'get',
        success: function (data){
        console.log(data)
        },
        error:function (err){
            console.log(err)
        }
    }))

    // return fetch(url).then((response)=>{
    //     return response.json();
    // })
}

async function FetchData(){
    try {
        const books=await FetchBook();
        console.log(books)
        console.log("123")


    }
    catch (error) {
        console.log(error)
    }

}
FetchData();