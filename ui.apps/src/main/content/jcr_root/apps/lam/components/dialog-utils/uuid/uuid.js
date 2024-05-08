'use strict';
use(function () {
    var uuid = {};
    uuid.id = new Date().getTime();
    uuid.class = 'uuid-class__' + uuid.id;
    return uuid;
});
