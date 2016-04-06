%{--
The code for a jqgrid
--}%

<script type="text/javascript">
    $(document).ready(function() {//code goes here
        jQuery("#allRoster").jqGrid({
            heigth: 'auto',
            width: '1000',
            caption: 'Roster List',
            url: 'Roster/roster',
            //editurl:
            datatype: "json",
            colNames: ['Name', 'Position', 'Department', 'Location'],
            colModel: [
                {name:'name', width:200, editable:true},
                {name:'position', width:200, editable:true},
                {name:'department', width:200, editable:true},
                {name:'location', width:200, editable:true}

            ],

            rowNum:20,
            rowList:[20,40,60],
            gridview: true,
            viewrecords: true,
            sortorder: "asc",
            autowidth:true,
            // scroll: true,
            forceFit:true,
            shrinkToFit: true,
            pager: '#rosterAllPager',
            scrollOffset:0,
            gridComplete: function() {
            }
        });
        jQuery("#allRoster").jqGrid('navGrid','#rosterAllPager',{edit:false,add:false,del:false});


        %{-- function to allow for searching a column for some string--}%
        jQuery('#allRoster').filterToolbar({id:'allRoster', searchOnEnter:true});
        $("#allRoster").jqGrid('navGrid','#rosterAllPager',{
                    add:false,
                    del:false,
                    edit:false,
                    refresh:false,
                    refreshstate:"current",
                    search:false
                },
                {},//edit options

                {recreateForm:true //since clearAfterAdd is trueby default, recreate the form so we re-establish value for parent id
                });

        %{--Not sure what exactly this does--}%
        jQuery("#grid_id").jqGrid({

            pager : '#rosterAllPager',

        });
        %{--Not sure what exactly this does--}%
        // jQuery("#grid_id").navGrid('#allMobileSuitsPager',"add_allMobileSuits" );



        jQuery(window).bind('resize', function() {

        }).trigger('resize');
    });



</script>


%{--tag for grid--}%
<table id="allRoster"></table>
%{--tag for pager--}%
<div id="rosterAllPager"></div>