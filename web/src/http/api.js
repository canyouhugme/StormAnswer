import httpFetch from './http'

/**
 * 查询问题和答案
 */
function getQa(pageSize, pageNo) {
    console.log('query pageSize', pageSize, pageNo)
    return httpFetch({
        url: '/abc',
        method: 'GET'
    })
}

/**
 * 按关键词搜索问题和答案
 * @param searchKey
 */
function searchQa(searchKey) {
    console.log('searchQa ', searchKey)
    return httpFetch({
        url: 'efg',
        method: 'GET'
    })
}

/**
 * 提交文章解析
 * @param articleUrl
 */
function postArticle(articleUrl) {
    console.log('post article', articleUrl)
    return httpFetch({
        url: '/123',
        method: 'POST'
    })
}

function saveQa(articleUrl) {
    console.log('save qa', articleUrl)
    return httpFetch({
        url: '/xyq',
        method: 'POST'
    })
}

export default {
    getQa,
    searchQa,
    postArticle,
    saveQa
}
