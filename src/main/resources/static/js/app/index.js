var main = { //중복 함수 이름이 발생할 수 있기 때문에 변수의 속성으로 function을 추가
    init : function(){
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });

        $('#btn-update').on('click', function () {
            //btn-update란 id를 가진 HTML 엘리멘트에 click 이벤트가 발생할 때 update function이 실행하도록 이벤트 등록
            _this.update();
        });

        $('#btn-delete').on('click', function(){
            _this.delete();
        })

    },
    save : function(){
        var data = {
            title : $('#title').val(),
            author : $('#author').val(),
            content : $('#content').val()
        };

        $.ajax({
            type : 'POST',
            url : '/api/v1/posts',
            dataType : 'json',
            contentType : 'application/json; charset=utf-8',
            data : JSON.stringify(data)
        }).done(function () {
            alert('글이 등록되었습니다.');
            window.location.href = '/'; //글 등록이 성공하면 메이페이지(/)로 이동
        }).fail(function (error) {
            alert(JSON.stringify(error))
        });
    },
    update : function(){ //update function
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        var id = $('#id').val();

        $.ajax({
                            type: 'PUT', //HTTP Method 중 PUT 메소드, PostsApiController에서 이미 @PutMapping을 선언했기 때문에 PUT을 사용해야 함
                            //REST 규약에 맞게 설정된 것, REST에서 CRUD는 HTTP Method에 맵핑 (생성: POST, 읽기: GET, 수정: PUT, 삭제: DELETE)
                            url: '/api/v1/posts/'+id, //어떤 게시글을 수정할지 URL Path로 구분하기 위해 Path에 id를 추가
                            dataType: 'json',
                            contentType:'application/json; charset=utf-8',
                            data: JSON.stringify(data)
                        }).done(function() {
                            alert('글이 수정되었습니다.');
                            window.location.href = '/';
                        }).fail(function (error) {
                            alert(JSON.stringify(error));
                        });
    },
    delete : function () {
            var id = $('#id').val();

            $.ajax({
                type: 'DELETE',
                url: '/api/v1/posts/'+id,
                dataType: 'json',
                contentType:'application/json; charset=utf-8'
            }).done(function() {
                alert('글이 삭제되었습니다.');
                window.location.href = '/';
            }).fail(function (error) {
                alert(JSON.stringify(error));
            });
        }
};

main.init();

