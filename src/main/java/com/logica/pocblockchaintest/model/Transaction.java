package com.logica.pocblockchaintest.model;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tuples.generated.Tuple4;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.1.1.
 */
public class Transaction extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b506120a4806100206000396000f3fe608060405234801561001057600080fd5b50600436106100a5576000357c0100000000000000000000000000000000000000000000000000000000900480638a1319ab116100785780638a1319ab14610515578063913c4840146106d7578063bd5981ae1461088d578063df88e91d14610933576100a5565b80630119290d146100aa57806325d77024146101e45780633a51d24614610322578063518bddd9146103da575b600080fd5b6101e2600480360360608110156100c057600080fd5b8101906020810181356401000000008111156100db57600080fd5b8201836020820111156100ed57600080fd5b8035906020019184600183028401116401000000008311171561010f57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929594936020810193503591505064010000000081111561016257600080fd5b82018360208201111561017457600080fd5b8035906020019184600183028401116401000000008311171561019657600080fd5b91908080601f01602080910402602001604051908101604052809392919081815260200183838082843760009201919091525092955050509035600160a060020a031691506109d99050565b005b61028a600480360360208110156101fa57600080fd5b81019060208101813564010000000081111561021557600080fd5b82018360208201111561022757600080fd5b8035906020019184600183028401116401000000008311171561024957600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550610c51945050505050565b604051808481526020018060200183600160a060020a0316600160a060020a03168152602001828103825284818151815260200191508051906020019080838360005b838110156102e55781810151838201526020016102cd565b50505050905090810190601f1680156103125780820380516001836020036101000a031916815260200191505b5094505050505060405180910390f35b6103c86004803603602081101561033857600080fd5b81019060208101813564010000000081111561035357600080fd5b82018360208201111561036557600080fd5b8035906020019184600183028401116401000000008311171561038757600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550610ed1945050505050565b60408051918252519081900360200190f35b610480600480360360208110156103f057600080fd5b81019060208101813564010000000081111561040b57600080fd5b82018360208201111561041d57600080fd5b8035906020019184600183028401116401000000008311171561043f57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550611148945050505050565b60408051858152908101839052600160a060020a038216606082015260806020808301828152865192840192909252855160a084019187019080838360005b838110156104d75781810151838201526020016104bf565b50505050905090810190601f1680156105045780820380516001836020036101000a031916815260200191505b509550505050505060405180910390f35b6101e2600480360360a081101561052b57600080fd5b81019060208101813564010000000081111561054657600080fd5b82018360208201111561055857600080fd5b8035906020019184600183028401116401000000008311171561057a57600080fd5b91908080601f01602080910402602001604051908101604052809392919081815260200183838082843760009201919091525092959493602081019350359150506401000000008111156105cd57600080fd5b8201836020820111156105df57600080fd5b8035906020019184600183028401116401000000008311171561060157600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929594936020810193503591505064010000000081111561065457600080fd5b82018360208201111561066657600080fd5b8035906020019184600183028401116401000000008311171561068857600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295505082359350505060200135600160a060020a03166113de565b6101e2600480360360808110156106ed57600080fd5b81019060208101813564010000000081111561070857600080fd5b82018360208201111561071a57600080fd5b8035906020019184600183028401116401000000008311171561073c57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929594936020810193503591505064010000000081111561078f57600080fd5b8201836020820111156107a157600080fd5b803590602001918460018302840111640100000000831117156107c357600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929594936020810193503591505064010000000081111561081657600080fd5b82018360208201111561082857600080fd5b8035906020019184600183028401116401000000008311171561084a57600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295505091359250611716915050565b6103c8600480360360208110156108a357600080fd5b8101906020810181356401000000008111156108be57600080fd5b8201836020820111156108d057600080fd5b803590602001918460018302840111640100000000831117156108f257600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550611928945050505050565b6101e26004803603602081101561094957600080fd5b81019060208101813564010000000081111561096457600080fd5b82018360208201111561097657600080fd5b8035906020019184600183028401116401000000008311171561099857600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600092019190915250929550611990945050505050565b6005836040518082805190602001908083835b60208310610a0b5780518252601f1990920191602091820191016109ec565b51815160209384036101000a600019018019909216911617905292019485525060405193849003019092205460ff16159150610a939050576040805160e560020a62461bcd02815260206004820152601360248201527f42616e6b20616c72656164792065786973747300000000000000000000000000604482015290519081900360640190fd5b6000805460010190819055604080516080810182529182526020808301869052828201859052600160a060020a03841660608401529051855160029287929182918401908083835b60208310610afa5780518252601f199092019160209182019101610adb565b51815160209384036101000a6000190180199092169116179052920194855250604051938490038101909320845181558484015180519194610b4494506001860193500190611eeb565b5060408201518051610b60916002840191602090910190611eeb565b5060608201518160030160006101000a815481600160a060020a030219169083600160a060020a0316021790555090505060016005846040518082805190602001908083835b60208310610bc55780518252601f199092019160209182019101610ba6565b51815160209384036101000a6000190180199092169116179052920194855250604051938490038101909320805460ff1916941515949094179093555060078054600181018083556000929092528651919350610c4a927fa66cc928b5edb82af9bd49922954155ab7b0942694bea4ce44661d9a8736c6889091019190870190611eeb565b5050505050565b6000606060006005846040518082805190602001908083835b60208310610c895780518252601f199092019160209182019101610c6a565b51815160001960209485036101000a0190811690199190911617905292019485525060405193849003019092205460ff1615156001149150610d059050576040805160e560020a62461bcd0281526020600482015260136024820152600080516020612039833981519152604482015290519081900360640190fd5b610d0d611f69565b6002856040518082805190602001908083835b60208310610d3f5780518252601f199092019160209182019101610d20565b518151602093840361010090810a60001990810180199094169390921692909217909252929094019687526040805197889003820188206080890182528054895260018082018054845160029382161590970290980190971604601f81018490048402850184019092528184529650878201955091939250830182828015610e085780601f10610ddd57610100808354040283529160200191610e08565b820191906000526020600020905b815481529060010190602001808311610deb57829003601f168201915b5050509183525050600282810180546040805160206001841615610100026000190190931694909404601f81018390048302850183019091528084529381019390830182828015610e9a5780601f10610e6f57610100808354040283529160200191610e9a565b820191906000526020600020905b815481529060010190602001808311610e7d57829003601f168201915b505050918352505060039190910154600160a060020a03166020918201528151908201516060909201519097919650945092505050565b60006006826040518082805190602001908083835b60208310610f055780518252601f199092019160209182019101610ee6565b51815160001960209485036101000a0190811690199190911617905292019485525060405193849003019092205460ff1615156001149150610f819050576040805160e560020a62461bcd0281526020600482015260176024820152600080516020612059833981519152604482015290519081900360640190fd5b610f89611f9b565b6003836040518082805190602001908083835b60208310610fbb5780518252601f199092019160209182019101610f9c565b518151602093840361010090810a600019908101801990941693909216929092179092529290940196875260408051978890038201882060a0890182528054895260018082018054845160029382161590970290980190971604601f810184900484028501840190925281845296508782019550919392508301828280156110845780601f1061105957610100808354040283529160200191611084565b820191906000526020600020905b81548152906001019060200180831161106757829003601f168201915b5050509183525050600282810180546040805160206001841615610100026000190190931694909404601f810183900483028501830190915280845293810193908301828280156111165780601f106110eb57610100808354040283529160200191611116565b820191906000526020600020905b8154815290600101906020018083116110f957829003601f168201915b505050918352505060038201546020820152600490910154600160a060020a0316604090910152606001519392505050565b600060606000806006856040518082805190602001908083835b602083106111815780518252601f199092019160209182019101611162565b51815160001960209485036101000a0190811690199190911617905292019485525060405193849003019092205460ff16151560011491506111fd9050576040805160e560020a62461bcd0281526020600482015260176024820152600080516020612059833981519152604482015290519081900360640190fd5b611205611f9b565b6003866040518082805190602001908083835b602083106112375780518252601f199092019160209182019101611218565b518151602093840361010090810a600019908101801990941693909216929092179092529290940196875260408051978890038201882060a0890182528054895260018082018054845160029382161590970290980190971604601f810184900484028501840190925281845296508782019550919392508301828280156113005780601f106112d557610100808354040283529160200191611300565b820191906000526020600020905b8154815290600101906020018083116112e357829003601f168201915b5050509183525050600282810180546040805160206001841615610100026000190190931694909404601f810183900483028501830190915280845293810193908301828280156113925780601f1061136757610100808354040283529160200191611392565b820191906000526020600020905b81548152906001019060200180831161137557829003601f168201915b50505091835250506003820154602080830191909152600490920154600160a060020a031660409091015281519082015160608301516080909301519199909850919650945092505050565b6005856040518082805190602001908083835b602083106114105780518252601f1990920191602091820191016113f1565b51815160001960209485036101000a0190811690199190911617905292019485525060405193849003019092205460ff161515600114915061148c9050576040805160e560020a62461bcd0281526020600482015260136024820152600080516020612039833981519152604482015290519081900360640190fd5b6006846040518082805190602001908083835b602083106114be5780518252601f19909201916020918201910161149f565b51815160209384036101000a600019018019909216911617905292019485525060405193849003019092205460ff161591506115469050576040805160e560020a62461bcd02815260206004820152601760248201527f437573746f6d657220616c726561647920657869737473000000000000000000604482015290519081900360640190fd5b600180548101908190556040805160a081018252918252602080830187905282820186905260608301859052600160a060020a03841660808401529051865160039288929182918401908083835b602083106115b35780518252601f199092019160209182019101611594565b51815160209384036101000a60001901801990921691161790529201948552506040519384900381019093208451815584840151805191946115fd94506001860193500190611eeb565b5060408201518051611619916002840191602090910190611eeb565b506060820151816003015560808201518160040160006101000a815481600160a060020a030219169083600160a060020a0316021790555090505060016006856040518082805190602001908083835b602083106116885780518252601f199092019160209182019101611669565b51815160209384036101000a6000190180199092169116179052920194855250604051938490038101909320805460ff191694151594909417909355506008805460018101808355600092909252875191935061170d927ff3f7a9fe364faab93b216da50a3214154f22a0a2b415b23a84c8169e8b636ee39091019190880190611eeb565b50505050505050565b6006846040518082805190602001908083835b602083106117485780518252601f199092019160209182019101611729565b51815160001960209485036101000a0190811690199190911617905292019485525060405193849003019092205460ff16151560011491506117c49050576040805160e560020a62461bcd0281526020600482015260176024820152600080516020612059833981519152604482015290519081900360640190fd5b6005836040518082805190602001908083835b602083106117f65780518252601f1990920191602091820191016117d7565b51815160001960209485036101000a0190811690199190911617905292019485525060405193849003019092205460ff16151560011491506118729050576040805160e560020a62461bcd0281526020600482015260136024820152600080516020612039833981519152604482015290519081900360640190fd5b6040805160808101825283815260208082018490529181018590526060810186905260048054600181018083556000839052835180519195929093027f8a35acfbc15ff81a39ae7d344fd709f28e8600b4aa8c65c6b64bfe7fe36bd19b01926118df928492910190611eeb565b506020828101516001830155604083015180516119029260028501920190611eeb565b506060820151805161191e916003840191602090910190611eeb565b5050505050505050565b60006002826040518082805190602001908083835b6020831061195c5780518252601f19909201916020918201910161193d565b51815160209384036101000a6000190180199092169116179052920194855250604051938490030190922054949350505050565b6005816040518082805190602001908083835b602083106119c25780518252601f1990920191602091820191016119a3565b51815160001960209485036101000a0190811690199190911617905292019485525060405193849003019092205460ff1615156001149150611a3e9050576040805160e560020a62461bcd0281526020600482015260136024820152600080516020612039833981519152604482015290519081900360640190fd5b60005b600454811015611c3a57611a5482611928565b611b08600483815481101515611a6657fe5b600091825260209182902060026004909202018101805460408051601f600019610100600186161502019093169490940491820185900485028401850190528083529192909190830182828015611afe5780601f10611ad357610100808354040283529160200191611afe565b820191906000526020600020905b815481529060010190602001808311611ae157829003601f168201915b5050505050611928565b1415611c3257611be1600482815481101515611b2057fe5b906000526020600020906004020160010154600483815481101515611b4157fe5b6000918252602091829020600360049092020101805460408051601f6002600019610100600187161502019094169390930492830185900485028101850190915281815292830182828015611bd75780601f10611bac57610100808354040283529160200191611bd7565b820191906000526020600020905b815481529060010190602001808311611bba57829003601f168201915b5050505050611c3e565b6004805482908110611bef57fe5b60009182526020822060049091020190611c098282611fd4565b6001820160009055600282016000611c219190611fd4565b611c2f600383016000611fd4565b50505b600101611a41565b5050565b6006816040518082805190602001908083835b60208310611c705780518252601f199092019160209182019101611c51565b51815160001960209485036101000a0190811690199190911617905292019485525060405193849003019092205460ff1615156001149150611cec9050576040805160e560020a62461bcd0281526020600482015260176024820152600080516020612059833981519152604482015290519081900360640190fd5b816003826040518082805190602001908083835b60208310611d1f5780518252601f199092019160209182019101611d00565b51815160209384036101000a60001901801990921691161790529201948552506040519384900381018420600390810180549690960190955585517f5076734a4906642dd341ffaf6dbe348db33f8afd96ebf4a45a7c84c9dd2cd67a9594879450925082918401908083835b60208310611daa5780518252601f199092019160209182019101611d8b565b6001836020036101000a03801982511681845116808217855250505050505090500191505090815260200160405180910390206001016003836040518082805190602001908083835b60208310611e125780518252601f199092019160209182019101611df3565b6001836020036101000a0380198251168184511680821785525050505050509050019150509081526020016040518091039020600301546040518080602001838152602001828103825284818154600181600116156101000203166002900481526020019150805460018160011615610100020316600290048015611ed85780601f10611ead57610100808354040283529160200191611ed8565b820191906000526020600020905b815481529060010190602001808311611ebb57829003601f168201915b5050935050505060405180910390a15050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10611f2c57805160ff1916838001178555611f59565b82800160010185558215611f59579182015b82811115611f59578251825591602001919060010190611f3e565b50611f6592915061201b565b5090565b6080604051908101604052806000815260200160608152602001606081526020016000600160a060020a031681525090565b60a060405190810160405280600081526020016060815260200160608152602001600081526020016000600160a060020a031681525090565b50805460018160011615610100020316600290046000825580601f10611ffa5750612018565b601f016020900490600052602060002090810190612018919061201b565b50565b61203591905b80821115611f655760008155600101612021565b9056fe42616e6b20646f6573206e6f7420657869737400000000000000000000000000437573746f6d657220646f6573206e6f74206578697374000000000000000000a165627a7a7230582009170e8b61fcf690120640ccadcb3eda0fd0291ce008793b611a4e90814501570029";

    public static final String FUNC_SETBANK = "setBank";

    public static final String FUNC_GETBANK = "getBank";

    public static final String FUNC_GETBALANCE = "getBalance";

    public static final String FUNC_GETCUSTOMER = "getCustomer";

    public static final String FUNC_SETCUSTOMER = "setCustomer";

    public static final String FUNC_REQUESTBALANCEUPDATE = "requestBalanceUpdate";

    public static final String FUNC_GETBANKID = "getBankId";

    public static final String FUNC_VERIFYSTATEMENT = "verifyStatement";

    public static final Event CUSTOMERINFO_EVENT = new Event("CustomerInfo", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected Transaction(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Transaction(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Transaction(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Transaction(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> setBank(String _bankName, String _accountPassword, String _bankAddress) {
        final Function function = new Function(
                FUNC_SETBANK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_bankName), 
                new org.web3j.abi.datatypes.Utf8String(_accountPassword), 
                new org.web3j.abi.datatypes.Address(_bankAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple3<BigInteger, String, String>> getBank(String _bankName) {
        final Function function = new Function(FUNC_GETBANK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_bankName)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Address>() {}));
        return new RemoteCall<Tuple3<BigInteger, String, String>>(
                new Callable<Tuple3<BigInteger, String, String>>() {
                    @Override
                    public Tuple3<BigInteger, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<BigInteger, String, String>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue());
                    }
                });
    }

    public RemoteCall<BigInteger> getBalance(String _customerName) {
        final Function function = new Function(FUNC_GETBALANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_customerName)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Tuple4<BigInteger, String, BigInteger, String>> getCustomer(String _customerName) {
        final Function function = new Function(FUNC_GETCUSTOMER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_customerName)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}));
        return new RemoteCall<Tuple4<BigInteger, String, BigInteger, String>>(
                new Callable<Tuple4<BigInteger, String, BigInteger, String>>() {
                    @Override
                    public Tuple4<BigInteger, String, BigInteger, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<BigInteger, String, BigInteger, String>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (String) results.get(3).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> setCustomer(String _bankName, String _customerName, String _accountPassword, BigInteger _balance, String _customerAddress) {
        final Function function = new Function(
                FUNC_SETCUSTOMER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_bankName), 
                new org.web3j.abi.datatypes.Utf8String(_customerName), 
                new org.web3j.abi.datatypes.Utf8String(_accountPassword), 
                new org.web3j.abi.datatypes.generated.Uint256(_balance), 
                new org.web3j.abi.datatypes.Address(_customerAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> requestBalanceUpdate(String _customerName, String _bankName, String _message, BigInteger _balance) {
        final Function function = new Function(
                FUNC_REQUESTBALANCEUPDATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_customerName), 
                new org.web3j.abi.datatypes.Utf8String(_bankName), 
                new org.web3j.abi.datatypes.Utf8String(_message), 
                new org.web3j.abi.datatypes.generated.Uint256(_balance)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> getBankId(String _bankName) {
        final Function function = new Function(FUNC_GETBANKID, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_bankName)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> verifyStatement(String _bankName) {
        final Function function = new Function(
                FUNC_VERIFYSTATEMENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_bankName)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public List<CustomerInfoEventResponse> getCustomerInfoEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(CUSTOMERINFO_EVENT, transactionReceipt);
        ArrayList<CustomerInfoEventResponse> responses = new ArrayList<CustomerInfoEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            CustomerInfoEventResponse typedResponse = new CustomerInfoEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.customerName = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.balance = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<CustomerInfoEventResponse> customerInfoEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, CustomerInfoEventResponse>() {
            @Override
            public CustomerInfoEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CUSTOMERINFO_EVENT, log);
                CustomerInfoEventResponse typedResponse = new CustomerInfoEventResponse();
                typedResponse.log = log;
                typedResponse.customerName = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.balance = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<CustomerInfoEventResponse> customerInfoEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CUSTOMERINFO_EVENT));
        return customerInfoEventFlowable(filter);
    }

    @Deprecated
    public static Transaction load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Transaction(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Transaction load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Transaction(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Transaction load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Transaction(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Transaction load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Transaction(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Transaction> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Transaction.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Transaction> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Transaction.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Transaction> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Transaction.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Transaction> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Transaction.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class CustomerInfoEventResponse {
        public Log log;

        public String customerName;

        public BigInteger balance;
    }
}