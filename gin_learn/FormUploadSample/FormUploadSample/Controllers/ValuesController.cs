﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Http;
using System.Net.Http.Headers;
using System.IO;

namespace FormUploadSample.Controllers
{
    [Route("api/[controller]")]
    public class ValuesController : Controller
    {
        // GET api/values
        [HttpGet]
        public IEnumerable<string> Get()
        {
            return new string[] { "value1", "value2" };
        }

        // GET api/values/5
        [HttpGet("{id}")]
        public string Get(int id)
        {
            return "value";
        }
        [HttpPost("upload")]
        public async Task<string> UploadFiles(ModelTest test)
        {
            string key1 = test.key1;
            string key2 = test.key2;
            string key3 = test.key3;
            IFormFile file1 = test.file1;
            IFormFile file2 = test.file1;
            var path = Path.Combine(@"D:\temp", file1.FileName);
            using (var stream = System.IO.File.Create(path))
            {
                //保存到本地
                await file1.CopyToAsync(stream);
            }

            return "OK";
        }
        // POST api/values
        [HttpPost]
        public void Post([FromBody]string value)
        {
        }

        // PUT api/values/5
        [HttpPut("{id}")]
        public void Put(int id, [FromBody]string value)
        {
        }

        // DELETE api/values/5
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
        }
    }

    public class ModelTest
    {
        public string key1 { set; get; }
        public string key2 { set; get; }
        public string key3 { set; get; }
        public IFormFile file1 { set; get; }

        public IFormFile file2 { set; get; }
    }
}